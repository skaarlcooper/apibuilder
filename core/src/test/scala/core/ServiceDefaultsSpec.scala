package core

import org.scalatest.{FunSpec, Matchers}

class ServiceDefaultsSpec extends FunSpec with Matchers {

  it("accepts defaults for date-iso8601") {
    val json = """
    {
      "name": "Api Doc",
      "apidoc": { "version": "0.9.6" },
      "models": {
        "user": {
          "fields": [
            { "name": "created_at", "type": "date-iso8601", "default": "2014-01-01" }
          ]
        }
      }
    }
    """
    val validator = TestHelper.serviceValidatorFromApiJson(json)
    validator.errors.mkString("") should be("")

    val createdAt = validator.service.models.head.fields.find { _.name == "created_at" }.get
    createdAt.default should be(Some("2014-01-01"))
  }

  it("accepts strings and values as defaults for booleans") {
    val json = """
    {
      "name": "Api Doc",
      "apidoc": { "version": "0.9.6" },
      "models": {
        "user": {
          "fields": [
            { "name": "is_active", "type": "boolean", "default": "true", "required": true },
            { "name": "is_athlete", "type": "boolean", "default": "false", "required": "true" }
          ]
        }
      }
    }
    """
    val validator = TestHelper.serviceValidatorFromApiJson(json)
    validator.errors.mkString("") should be("")

    val isActiveField = validator.service.models.head.fields.find { _.name == "is_active" }.get
    isActiveField.default should be(Some("true"))
    isActiveField.required should be(true)

    val isAthleteField = validator.service.models.head.fields.find { _.name == "is_athlete" }.get
    isAthleteField.default should be(Some("false"))
    isAthleteField.required should be(true)
  }

  it("rejects invalid boolean defaults") {
    val json = """
    {
      "name": "Api Doc",
      "apidoc": { "version": "0.9.6" },
      "models": {
        "user": {
          "fields": [
            { "name": "is_active", "type": "boolean", "default": 1 }
          ]
        }
      }
    }
    """
    val validator = TestHelper.serviceValidatorFromApiJson(json)
    validator.errors.mkString("") should be("user.is_active Value[1] is not a valid boolean. Must be one of: true, false")
  }

  it("fields with defaults must be marked required") {
    val json = """
    {
      "name": "Api Doc",
      "apidoc": { "version": "0.9.6" },

      "models": {
        "user": {
          "fields": [
            { "name": "created_at", "type": "date-iso8601", "default": "2014-01-01", "required": false }
          ]
        }
      }
    }
    """
    val validator = TestHelper.serviceValidatorFromApiJson(json)
    validator.errors.mkString("") should be("user.created_at has a default specified. It must be marked required")
  }

  def buildMinMaxErrors(
    default: Long,
    min: Option[Long] = None,
    max: Option[Long] = None
  ) = {
    val props = Seq(
      min.map { v => s""""minimum" = "$v"""" },
      max.map { v => s""""maximum" = "$v"""" }
    ).flatten.mkString(", ")

    val json = s"""
    {
      "name": "Api Doc",
      "models": {
        "user": {
          "fields": [
            { "name": "age", "type": "boolean", "default": "$default"$props }
          ]
        }
      }
    }
    """
    TestHelper.serviceValidatorFromApiJson(json).errors

  }

  it("validates that numeric default is in between min, max") {
    buildMinMaxErrors(1) should be(Nil)
  }
  
}
