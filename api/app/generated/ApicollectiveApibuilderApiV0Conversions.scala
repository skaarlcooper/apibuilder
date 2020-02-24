/**
 * Generated by API Builder - https://www.apibuilder.io
 * Service version: 0.14.85
 * apibuilder 0.14.75 app.apibuilder.io/apicollective/apibuilder-api/0.14.85/anorm_2_6_parsers
 */
package io.apibuilder.api.v0.anorm.conversions {

  import anorm.{Column, MetaDataItem, TypeDoesNotMatch}
  import play.api.libs.json.{JsArray, JsObject, JsValue}
  import scala.util.{Failure, Success, Try}
  import play.api.libs.json.JodaReads._

  /**
    * Conversions to collections of objects using JSON.
    */
  object Util {

    def parser[T](
      f: play.api.libs.json.JsValue => T
    ) = anorm.Column.nonNull { (value, meta) =>
      val MetaDataItem(columnName, nullable, clazz) = meta
      value match {
        case json: org.postgresql.util.PGobject => parseJson(f, columnName.qualified, json.getValue)
        case json: java.lang.String => parseJson(f, columnName.qualified, json)
        case _=> {
          Left(
            TypeDoesNotMatch(
              s"Column[${columnName.qualified}] error converting $value to Json. Expected instance of type[org.postgresql.util.PGobject] and not[${value.asInstanceOf[AnyRef].getClass}]"
            )
          )
        }


      }
    }

    private[this] def parseJson[T](f: play.api.libs.json.JsValue => T, columnName: String, value: String) = {
      Try {
        f(
          play.api.libs.json.Json.parse(value)
        )
      } match {
        case Success(result) => Right(result)
        case Failure(ex) => Left(
          TypeDoesNotMatch(
            s"Column[$columnName] error parsing json $value: $ex"
          )
        )
      }
    }

  }

  object Types {
    import io.apibuilder.api.v0.models.json._
    implicit val columnToSeqApibuilderApiAppSortBy: Column[Seq[_root_.io.apibuilder.api.v0.models.AppSortBy]] = Util.parser { _.as[Seq[_root_.io.apibuilder.api.v0.models.AppSortBy]] }
    implicit val columnToMapApibuilderApiAppSortBy: Column[Map[String, _root_.io.apibuilder.api.v0.models.AppSortBy]] = Util.parser { _.as[Map[String, _root_.io.apibuilder.api.v0.models.AppSortBy]] }
    implicit val columnToSeqApibuilderApiOriginalType: Column[Seq[_root_.io.apibuilder.api.v0.models.OriginalType]] = Util.parser { _.as[Seq[_root_.io.apibuilder.api.v0.models.OriginalType]] }
    implicit val columnToMapApibuilderApiOriginalType: Column[Map[String, _root_.io.apibuilder.api.v0.models.OriginalType]] = Util.parser { _.as[Map[String, _root_.io.apibuilder.api.v0.models.OriginalType]] }
    implicit val columnToSeqApibuilderApiPublication: Column[Seq[_root_.io.apibuilder.api.v0.models.Publication]] = Util.parser { _.as[Seq[_root_.io.apibuilder.api.v0.models.Publication]] }
    implicit val columnToMapApibuilderApiPublication: Column[Map[String, _root_.io.apibuilder.api.v0.models.Publication]] = Util.parser { _.as[Map[String, _root_.io.apibuilder.api.v0.models.Publication]] }
    implicit val columnToSeqApibuilderApiSortOrder: Column[Seq[_root_.io.apibuilder.api.v0.models.SortOrder]] = Util.parser { _.as[Seq[_root_.io.apibuilder.api.v0.models.SortOrder]] }
    implicit val columnToMapApibuilderApiSortOrder: Column[Map[String, _root_.io.apibuilder.api.v0.models.SortOrder]] = Util.parser { _.as[Map[String, _root_.io.apibuilder.api.v0.models.SortOrder]] }
    implicit val columnToSeqApibuilderApiVisibility: Column[Seq[_root_.io.apibuilder.api.v0.models.Visibility]] = Util.parser { _.as[Seq[_root_.io.apibuilder.api.v0.models.Visibility]] }
    implicit val columnToMapApibuilderApiVisibility: Column[Map[String, _root_.io.apibuilder.api.v0.models.Visibility]] = Util.parser { _.as[Map[String, _root_.io.apibuilder.api.v0.models.Visibility]] }
    implicit val columnToSeqApibuilderApiApplication: Column[Seq[_root_.io.apibuilder.api.v0.models.Application]] = Util.parser { _.as[Seq[_root_.io.apibuilder.api.v0.models.Application]] }
    implicit val columnToMapApibuilderApiApplication: Column[Map[String, _root_.io.apibuilder.api.v0.models.Application]] = Util.parser { _.as[Map[String, _root_.io.apibuilder.api.v0.models.Application]] }
    implicit val columnToSeqApibuilderApiApplicationForm: Column[Seq[_root_.io.apibuilder.api.v0.models.ApplicationForm]] = Util.parser { _.as[Seq[_root_.io.apibuilder.api.v0.models.ApplicationForm]] }
    implicit val columnToMapApibuilderApiApplicationForm: Column[Map[String, _root_.io.apibuilder.api.v0.models.ApplicationForm]] = Util.parser { _.as[Map[String, _root_.io.apibuilder.api.v0.models.ApplicationForm]] }
    implicit val columnToSeqApibuilderApiApplicationMetadata: Column[Seq[_root_.io.apibuilder.api.v0.models.ApplicationMetadata]] = Util.parser { _.as[Seq[_root_.io.apibuilder.api.v0.models.ApplicationMetadata]] }
    implicit val columnToMapApibuilderApiApplicationMetadata: Column[Map[String, _root_.io.apibuilder.api.v0.models.ApplicationMetadata]] = Util.parser { _.as[Map[String, _root_.io.apibuilder.api.v0.models.ApplicationMetadata]] }
    implicit val columnToSeqApibuilderApiApplicationMetadataVersion: Column[Seq[_root_.io.apibuilder.api.v0.models.ApplicationMetadataVersion]] = Util.parser { _.as[Seq[_root_.io.apibuilder.api.v0.models.ApplicationMetadataVersion]] }
    implicit val columnToMapApibuilderApiApplicationMetadataVersion: Column[Map[String, _root_.io.apibuilder.api.v0.models.ApplicationMetadataVersion]] = Util.parser { _.as[Map[String, _root_.io.apibuilder.api.v0.models.ApplicationMetadataVersion]] }
    implicit val columnToSeqApibuilderApiApplicationSummary: Column[Seq[_root_.io.apibuilder.api.v0.models.ApplicationSummary]] = Util.parser { _.as[Seq[_root_.io.apibuilder.api.v0.models.ApplicationSummary]] }
    implicit val columnToMapApibuilderApiApplicationSummary: Column[Map[String, _root_.io.apibuilder.api.v0.models.ApplicationSummary]] = Util.parser { _.as[Map[String, _root_.io.apibuilder.api.v0.models.ApplicationSummary]] }
    implicit val columnToSeqApibuilderApiAttribute: Column[Seq[_root_.io.apibuilder.api.v0.models.Attribute]] = Util.parser { _.as[Seq[_root_.io.apibuilder.api.v0.models.Attribute]] }
    implicit val columnToMapApibuilderApiAttribute: Column[Map[String, _root_.io.apibuilder.api.v0.models.Attribute]] = Util.parser { _.as[Map[String, _root_.io.apibuilder.api.v0.models.Attribute]] }
    implicit val columnToSeqApibuilderApiAttributeForm: Column[Seq[_root_.io.apibuilder.api.v0.models.AttributeForm]] = Util.parser { _.as[Seq[_root_.io.apibuilder.api.v0.models.AttributeForm]] }
    implicit val columnToMapApibuilderApiAttributeForm: Column[Map[String, _root_.io.apibuilder.api.v0.models.AttributeForm]] = Util.parser { _.as[Map[String, _root_.io.apibuilder.api.v0.models.AttributeForm]] }
    implicit val columnToSeqApibuilderApiAttributeSummary: Column[Seq[_root_.io.apibuilder.api.v0.models.AttributeSummary]] = Util.parser { _.as[Seq[_root_.io.apibuilder.api.v0.models.AttributeSummary]] }
    implicit val columnToMapApibuilderApiAttributeSummary: Column[Map[String, _root_.io.apibuilder.api.v0.models.AttributeSummary]] = Util.parser { _.as[Map[String, _root_.io.apibuilder.api.v0.models.AttributeSummary]] }
    implicit val columnToSeqApibuilderApiAttributeValue: Column[Seq[_root_.io.apibuilder.api.v0.models.AttributeValue]] = Util.parser { _.as[Seq[_root_.io.apibuilder.api.v0.models.AttributeValue]] }
    implicit val columnToMapApibuilderApiAttributeValue: Column[Map[String, _root_.io.apibuilder.api.v0.models.AttributeValue]] = Util.parser { _.as[Map[String, _root_.io.apibuilder.api.v0.models.AttributeValue]] }
    implicit val columnToSeqApibuilderApiAttributeValueForm: Column[Seq[_root_.io.apibuilder.api.v0.models.AttributeValueForm]] = Util.parser { _.as[Seq[_root_.io.apibuilder.api.v0.models.AttributeValueForm]] }
    implicit val columnToMapApibuilderApiAttributeValueForm: Column[Map[String, _root_.io.apibuilder.api.v0.models.AttributeValueForm]] = Util.parser { _.as[Map[String, _root_.io.apibuilder.api.v0.models.AttributeValueForm]] }
    implicit val columnToSeqApibuilderApiAuthentication: Column[Seq[_root_.io.apibuilder.api.v0.models.Authentication]] = Util.parser { _.as[Seq[_root_.io.apibuilder.api.v0.models.Authentication]] }
    implicit val columnToMapApibuilderApiAuthentication: Column[Map[String, _root_.io.apibuilder.api.v0.models.Authentication]] = Util.parser { _.as[Map[String, _root_.io.apibuilder.api.v0.models.Authentication]] }
    implicit val columnToSeqApibuilderApiChange: Column[Seq[_root_.io.apibuilder.api.v0.models.Change]] = Util.parser { _.as[Seq[_root_.io.apibuilder.api.v0.models.Change]] }
    implicit val columnToMapApibuilderApiChange: Column[Map[String, _root_.io.apibuilder.api.v0.models.Change]] = Util.parser { _.as[Map[String, _root_.io.apibuilder.api.v0.models.Change]] }
    implicit val columnToSeqApibuilderApiChangeVersion: Column[Seq[_root_.io.apibuilder.api.v0.models.ChangeVersion]] = Util.parser { _.as[Seq[_root_.io.apibuilder.api.v0.models.ChangeVersion]] }
    implicit val columnToMapApibuilderApiChangeVersion: Column[Map[String, _root_.io.apibuilder.api.v0.models.ChangeVersion]] = Util.parser { _.as[Map[String, _root_.io.apibuilder.api.v0.models.ChangeVersion]] }
    implicit val columnToSeqApibuilderApiCleartextToken: Column[Seq[_root_.io.apibuilder.api.v0.models.CleartextToken]] = Util.parser { _.as[Seq[_root_.io.apibuilder.api.v0.models.CleartextToken]] }
    implicit val columnToMapApibuilderApiCleartextToken: Column[Map[String, _root_.io.apibuilder.api.v0.models.CleartextToken]] = Util.parser { _.as[Map[String, _root_.io.apibuilder.api.v0.models.CleartextToken]] }
    implicit val columnToSeqApibuilderApiCode: Column[Seq[_root_.io.apibuilder.api.v0.models.Code]] = Util.parser { _.as[Seq[_root_.io.apibuilder.api.v0.models.Code]] }
    implicit val columnToMapApibuilderApiCode: Column[Map[String, _root_.io.apibuilder.api.v0.models.Code]] = Util.parser { _.as[Map[String, _root_.io.apibuilder.api.v0.models.Code]] }
    implicit val columnToSeqApibuilderApiCodeForm: Column[Seq[_root_.io.apibuilder.api.v0.models.CodeForm]] = Util.parser { _.as[Seq[_root_.io.apibuilder.api.v0.models.CodeForm]] }
    implicit val columnToMapApibuilderApiCodeForm: Column[Map[String, _root_.io.apibuilder.api.v0.models.CodeForm]] = Util.parser { _.as[Map[String, _root_.io.apibuilder.api.v0.models.CodeForm]] }
    implicit val columnToSeqApibuilderApiDiffBreaking: Column[Seq[_root_.io.apibuilder.api.v0.models.DiffBreaking]] = Util.parser { _.as[Seq[_root_.io.apibuilder.api.v0.models.DiffBreaking]] }
    implicit val columnToMapApibuilderApiDiffBreaking: Column[Map[String, _root_.io.apibuilder.api.v0.models.DiffBreaking]] = Util.parser { _.as[Map[String, _root_.io.apibuilder.api.v0.models.DiffBreaking]] }
    implicit val columnToSeqApibuilderApiDiffNonBreaking: Column[Seq[_root_.io.apibuilder.api.v0.models.DiffNonBreaking]] = Util.parser { _.as[Seq[_root_.io.apibuilder.api.v0.models.DiffNonBreaking]] }
    implicit val columnToMapApibuilderApiDiffNonBreaking: Column[Map[String, _root_.io.apibuilder.api.v0.models.DiffNonBreaking]] = Util.parser { _.as[Map[String, _root_.io.apibuilder.api.v0.models.DiffNonBreaking]] }
    implicit val columnToSeqApibuilderApiDomain: Column[Seq[_root_.io.apibuilder.api.v0.models.Domain]] = Util.parser { _.as[Seq[_root_.io.apibuilder.api.v0.models.Domain]] }
    implicit val columnToMapApibuilderApiDomain: Column[Map[String, _root_.io.apibuilder.api.v0.models.Domain]] = Util.parser { _.as[Map[String, _root_.io.apibuilder.api.v0.models.Domain]] }
    implicit val columnToSeqApibuilderApiEmailVerificationConfirmationForm: Column[Seq[_root_.io.apibuilder.api.v0.models.EmailVerificationConfirmationForm]] = Util.parser { _.as[Seq[_root_.io.apibuilder.api.v0.models.EmailVerificationConfirmationForm]] }
    implicit val columnToMapApibuilderApiEmailVerificationConfirmationForm: Column[Map[String, _root_.io.apibuilder.api.v0.models.EmailVerificationConfirmationForm]] = Util.parser { _.as[Map[String, _root_.io.apibuilder.api.v0.models.EmailVerificationConfirmationForm]] }
    implicit val columnToSeqApibuilderApiError: Column[Seq[_root_.io.apibuilder.api.v0.models.Error]] = Util.parser { _.as[Seq[_root_.io.apibuilder.api.v0.models.Error]] }
    implicit val columnToMapApibuilderApiError: Column[Map[String, _root_.io.apibuilder.api.v0.models.Error]] = Util.parser { _.as[Map[String, _root_.io.apibuilder.api.v0.models.Error]] }
    implicit val columnToSeqApibuilderApiGeneratorForm: Column[Seq[_root_.io.apibuilder.api.v0.models.GeneratorForm]] = Util.parser { _.as[Seq[_root_.io.apibuilder.api.v0.models.GeneratorForm]] }
    implicit val columnToMapApibuilderApiGeneratorForm: Column[Map[String, _root_.io.apibuilder.api.v0.models.GeneratorForm]] = Util.parser { _.as[Map[String, _root_.io.apibuilder.api.v0.models.GeneratorForm]] }
    implicit val columnToSeqApibuilderApiGeneratorService: Column[Seq[_root_.io.apibuilder.api.v0.models.GeneratorService]] = Util.parser { _.as[Seq[_root_.io.apibuilder.api.v0.models.GeneratorService]] }
    implicit val columnToMapApibuilderApiGeneratorService: Column[Map[String, _root_.io.apibuilder.api.v0.models.GeneratorService]] = Util.parser { _.as[Map[String, _root_.io.apibuilder.api.v0.models.GeneratorService]] }
    implicit val columnToSeqApibuilderApiGeneratorServiceForm: Column[Seq[_root_.io.apibuilder.api.v0.models.GeneratorServiceForm]] = Util.parser { _.as[Seq[_root_.io.apibuilder.api.v0.models.GeneratorServiceForm]] }
    implicit val columnToMapApibuilderApiGeneratorServiceForm: Column[Map[String, _root_.io.apibuilder.api.v0.models.GeneratorServiceForm]] = Util.parser { _.as[Map[String, _root_.io.apibuilder.api.v0.models.GeneratorServiceForm]] }
    implicit val columnToSeqApibuilderApiGeneratorWithService: Column[Seq[_root_.io.apibuilder.api.v0.models.GeneratorWithService]] = Util.parser { _.as[Seq[_root_.io.apibuilder.api.v0.models.GeneratorWithService]] }
    implicit val columnToMapApibuilderApiGeneratorWithService: Column[Map[String, _root_.io.apibuilder.api.v0.models.GeneratorWithService]] = Util.parser { _.as[Map[String, _root_.io.apibuilder.api.v0.models.GeneratorWithService]] }
    implicit val columnToSeqApibuilderApiItem: Column[Seq[_root_.io.apibuilder.api.v0.models.Item]] = Util.parser { _.as[Seq[_root_.io.apibuilder.api.v0.models.Item]] }
    implicit val columnToMapApibuilderApiItem: Column[Map[String, _root_.io.apibuilder.api.v0.models.Item]] = Util.parser { _.as[Map[String, _root_.io.apibuilder.api.v0.models.Item]] }
    implicit val columnToSeqApibuilderApiMembership: Column[Seq[_root_.io.apibuilder.api.v0.models.Membership]] = Util.parser { _.as[Seq[_root_.io.apibuilder.api.v0.models.Membership]] }
    implicit val columnToMapApibuilderApiMembership: Column[Map[String, _root_.io.apibuilder.api.v0.models.Membership]] = Util.parser { _.as[Map[String, _root_.io.apibuilder.api.v0.models.Membership]] }
    implicit val columnToSeqApibuilderApiMembershipRequest: Column[Seq[_root_.io.apibuilder.api.v0.models.MembershipRequest]] = Util.parser { _.as[Seq[_root_.io.apibuilder.api.v0.models.MembershipRequest]] }
    implicit val columnToMapApibuilderApiMembershipRequest: Column[Map[String, _root_.io.apibuilder.api.v0.models.MembershipRequest]] = Util.parser { _.as[Map[String, _root_.io.apibuilder.api.v0.models.MembershipRequest]] }
    implicit val columnToSeqApibuilderApiMoveForm: Column[Seq[_root_.io.apibuilder.api.v0.models.MoveForm]] = Util.parser { _.as[Seq[_root_.io.apibuilder.api.v0.models.MoveForm]] }
    implicit val columnToMapApibuilderApiMoveForm: Column[Map[String, _root_.io.apibuilder.api.v0.models.MoveForm]] = Util.parser { _.as[Map[String, _root_.io.apibuilder.api.v0.models.MoveForm]] }
    implicit val columnToSeqApibuilderApiOrganization: Column[Seq[_root_.io.apibuilder.api.v0.models.Organization]] = Util.parser { _.as[Seq[_root_.io.apibuilder.api.v0.models.Organization]] }
    implicit val columnToMapApibuilderApiOrganization: Column[Map[String, _root_.io.apibuilder.api.v0.models.Organization]] = Util.parser { _.as[Map[String, _root_.io.apibuilder.api.v0.models.Organization]] }
    implicit val columnToSeqApibuilderApiOrganizationForm: Column[Seq[_root_.io.apibuilder.api.v0.models.OrganizationForm]] = Util.parser { _.as[Seq[_root_.io.apibuilder.api.v0.models.OrganizationForm]] }
    implicit val columnToMapApibuilderApiOrganizationForm: Column[Map[String, _root_.io.apibuilder.api.v0.models.OrganizationForm]] = Util.parser { _.as[Map[String, _root_.io.apibuilder.api.v0.models.OrganizationForm]] }
    implicit val columnToSeqApibuilderApiOriginal: Column[Seq[_root_.io.apibuilder.api.v0.models.Original]] = Util.parser { _.as[Seq[_root_.io.apibuilder.api.v0.models.Original]] }
    implicit val columnToMapApibuilderApiOriginal: Column[Map[String, _root_.io.apibuilder.api.v0.models.Original]] = Util.parser { _.as[Map[String, _root_.io.apibuilder.api.v0.models.Original]] }
    implicit val columnToSeqApibuilderApiOriginalForm: Column[Seq[_root_.io.apibuilder.api.v0.models.OriginalForm]] = Util.parser { _.as[Seq[_root_.io.apibuilder.api.v0.models.OriginalForm]] }
    implicit val columnToMapApibuilderApiOriginalForm: Column[Map[String, _root_.io.apibuilder.api.v0.models.OriginalForm]] = Util.parser { _.as[Map[String, _root_.io.apibuilder.api.v0.models.OriginalForm]] }
    implicit val columnToSeqApibuilderApiPasswordReset: Column[Seq[_root_.io.apibuilder.api.v0.models.PasswordReset]] = Util.parser { _.as[Seq[_root_.io.apibuilder.api.v0.models.PasswordReset]] }
    implicit val columnToMapApibuilderApiPasswordReset: Column[Map[String, _root_.io.apibuilder.api.v0.models.PasswordReset]] = Util.parser { _.as[Map[String, _root_.io.apibuilder.api.v0.models.PasswordReset]] }
    implicit val columnToSeqApibuilderApiPasswordResetRequest: Column[Seq[_root_.io.apibuilder.api.v0.models.PasswordResetRequest]] = Util.parser { _.as[Seq[_root_.io.apibuilder.api.v0.models.PasswordResetRequest]] }
    implicit val columnToMapApibuilderApiPasswordResetRequest: Column[Map[String, _root_.io.apibuilder.api.v0.models.PasswordResetRequest]] = Util.parser { _.as[Map[String, _root_.io.apibuilder.api.v0.models.PasswordResetRequest]] }
    implicit val columnToSeqApibuilderApiSession: Column[Seq[_root_.io.apibuilder.api.v0.models.Session]] = Util.parser { _.as[Seq[_root_.io.apibuilder.api.v0.models.Session]] }
    implicit val columnToMapApibuilderApiSession: Column[Map[String, _root_.io.apibuilder.api.v0.models.Session]] = Util.parser { _.as[Map[String, _root_.io.apibuilder.api.v0.models.Session]] }
    implicit val columnToSeqApibuilderApiSubscription: Column[Seq[_root_.io.apibuilder.api.v0.models.Subscription]] = Util.parser { _.as[Seq[_root_.io.apibuilder.api.v0.models.Subscription]] }
    implicit val columnToMapApibuilderApiSubscription: Column[Map[String, _root_.io.apibuilder.api.v0.models.Subscription]] = Util.parser { _.as[Map[String, _root_.io.apibuilder.api.v0.models.Subscription]] }
    implicit val columnToSeqApibuilderApiSubscriptionForm: Column[Seq[_root_.io.apibuilder.api.v0.models.SubscriptionForm]] = Util.parser { _.as[Seq[_root_.io.apibuilder.api.v0.models.SubscriptionForm]] }
    implicit val columnToMapApibuilderApiSubscriptionForm: Column[Map[String, _root_.io.apibuilder.api.v0.models.SubscriptionForm]] = Util.parser { _.as[Map[String, _root_.io.apibuilder.api.v0.models.SubscriptionForm]] }
    implicit val columnToSeqApibuilderApiToken: Column[Seq[_root_.io.apibuilder.api.v0.models.Token]] = Util.parser { _.as[Seq[_root_.io.apibuilder.api.v0.models.Token]] }
    implicit val columnToMapApibuilderApiToken: Column[Map[String, _root_.io.apibuilder.api.v0.models.Token]] = Util.parser { _.as[Map[String, _root_.io.apibuilder.api.v0.models.Token]] }
    implicit val columnToSeqApibuilderApiTokenForm: Column[Seq[_root_.io.apibuilder.api.v0.models.TokenForm]] = Util.parser { _.as[Seq[_root_.io.apibuilder.api.v0.models.TokenForm]] }
    implicit val columnToMapApibuilderApiTokenForm: Column[Map[String, _root_.io.apibuilder.api.v0.models.TokenForm]] = Util.parser { _.as[Map[String, _root_.io.apibuilder.api.v0.models.TokenForm]] }
    implicit val columnToSeqApibuilderApiUser: Column[Seq[_root_.io.apibuilder.api.v0.models.User]] = Util.parser { _.as[Seq[_root_.io.apibuilder.api.v0.models.User]] }
    implicit val columnToMapApibuilderApiUser: Column[Map[String, _root_.io.apibuilder.api.v0.models.User]] = Util.parser { _.as[Map[String, _root_.io.apibuilder.api.v0.models.User]] }
    implicit val columnToSeqApibuilderApiUserForm: Column[Seq[_root_.io.apibuilder.api.v0.models.UserForm]] = Util.parser { _.as[Seq[_root_.io.apibuilder.api.v0.models.UserForm]] }
    implicit val columnToMapApibuilderApiUserForm: Column[Map[String, _root_.io.apibuilder.api.v0.models.UserForm]] = Util.parser { _.as[Map[String, _root_.io.apibuilder.api.v0.models.UserForm]] }
    implicit val columnToSeqApibuilderApiUserSummary: Column[Seq[_root_.io.apibuilder.api.v0.models.UserSummary]] = Util.parser { _.as[Seq[_root_.io.apibuilder.api.v0.models.UserSummary]] }
    implicit val columnToMapApibuilderApiUserSummary: Column[Map[String, _root_.io.apibuilder.api.v0.models.UserSummary]] = Util.parser { _.as[Map[String, _root_.io.apibuilder.api.v0.models.UserSummary]] }
    implicit val columnToSeqApibuilderApiUserUpdateForm: Column[Seq[_root_.io.apibuilder.api.v0.models.UserUpdateForm]] = Util.parser { _.as[Seq[_root_.io.apibuilder.api.v0.models.UserUpdateForm]] }
    implicit val columnToMapApibuilderApiUserUpdateForm: Column[Map[String, _root_.io.apibuilder.api.v0.models.UserUpdateForm]] = Util.parser { _.as[Map[String, _root_.io.apibuilder.api.v0.models.UserUpdateForm]] }
    implicit val columnToSeqApibuilderApiValidation: Column[Seq[_root_.io.apibuilder.api.v0.models.Validation]] = Util.parser { _.as[Seq[_root_.io.apibuilder.api.v0.models.Validation]] }
    implicit val columnToMapApibuilderApiValidation: Column[Map[String, _root_.io.apibuilder.api.v0.models.Validation]] = Util.parser { _.as[Map[String, _root_.io.apibuilder.api.v0.models.Validation]] }
    implicit val columnToSeqApibuilderApiVersion: Column[Seq[_root_.io.apibuilder.api.v0.models.Version]] = Util.parser { _.as[Seq[_root_.io.apibuilder.api.v0.models.Version]] }
    implicit val columnToMapApibuilderApiVersion: Column[Map[String, _root_.io.apibuilder.api.v0.models.Version]] = Util.parser { _.as[Map[String, _root_.io.apibuilder.api.v0.models.Version]] }
    implicit val columnToSeqApibuilderApiVersionForm: Column[Seq[_root_.io.apibuilder.api.v0.models.VersionForm]] = Util.parser { _.as[Seq[_root_.io.apibuilder.api.v0.models.VersionForm]] }
    implicit val columnToMapApibuilderApiVersionForm: Column[Map[String, _root_.io.apibuilder.api.v0.models.VersionForm]] = Util.parser { _.as[Map[String, _root_.io.apibuilder.api.v0.models.VersionForm]] }
    implicit val columnToSeqApibuilderApiWatch: Column[Seq[_root_.io.apibuilder.api.v0.models.Watch]] = Util.parser { _.as[Seq[_root_.io.apibuilder.api.v0.models.Watch]] }
    implicit val columnToMapApibuilderApiWatch: Column[Map[String, _root_.io.apibuilder.api.v0.models.Watch]] = Util.parser { _.as[Map[String, _root_.io.apibuilder.api.v0.models.Watch]] }
    implicit val columnToSeqApibuilderApiWatchForm: Column[Seq[_root_.io.apibuilder.api.v0.models.WatchForm]] = Util.parser { _.as[Seq[_root_.io.apibuilder.api.v0.models.WatchForm]] }
    implicit val columnToMapApibuilderApiWatchForm: Column[Map[String, _root_.io.apibuilder.api.v0.models.WatchForm]] = Util.parser { _.as[Map[String, _root_.io.apibuilder.api.v0.models.WatchForm]] }
    implicit val columnToSeqApibuilderApiDiff: Column[Seq[_root_.io.apibuilder.api.v0.models.Diff]] = Util.parser { _.as[Seq[_root_.io.apibuilder.api.v0.models.Diff]] }
    implicit val columnToMapApibuilderApiDiff: Column[Map[String, _root_.io.apibuilder.api.v0.models.Diff]] = Util.parser { _.as[Map[String, _root_.io.apibuilder.api.v0.models.Diff]] }
    implicit val columnToSeqApibuilderApiItemDetail: Column[Seq[_root_.io.apibuilder.api.v0.models.ItemDetail]] = Util.parser { _.as[Seq[_root_.io.apibuilder.api.v0.models.ItemDetail]] }
    implicit val columnToMapApibuilderApiItemDetail: Column[Map[String, _root_.io.apibuilder.api.v0.models.ItemDetail]] = Util.parser { _.as[Map[String, _root_.io.apibuilder.api.v0.models.ItemDetail]] }
  }

  object Standard {
    implicit val columnToJsObject: Column[play.api.libs.json.JsObject] = Util.parser { _.as[play.api.libs.json.JsObject] }
    implicit val columnToSeqBoolean: Column[Seq[Boolean]] = Util.parser { _.as[Seq[Boolean]] }
    implicit val columnToMapBoolean: Column[Map[String, Boolean]] = Util.parser { _.as[Map[String, Boolean]] }
    implicit val columnToSeqDouble: Column[Seq[Double]] = Util.parser { _.as[Seq[Double]] }
    implicit val columnToMapDouble: Column[Map[String, Double]] = Util.parser { _.as[Map[String, Double]] }
    implicit val columnToSeqInt: Column[Seq[Int]] = Util.parser { _.as[Seq[Int]] }
    implicit val columnToMapInt: Column[Map[String, Int]] = Util.parser { _.as[Map[String, Int]] }
    implicit val columnToSeqLong: Column[Seq[Long]] = Util.parser { _.as[Seq[Long]] }
    implicit val columnToMapLong: Column[Map[String, Long]] = Util.parser { _.as[Map[String, Long]] }
    implicit val columnToSeqLocalDate: Column[Seq[_root_.org.joda.time.LocalDate]] = Util.parser { _.as[Seq[_root_.org.joda.time.LocalDate]] }
    implicit val columnToMapLocalDate: Column[Map[String, _root_.org.joda.time.LocalDate]] = Util.parser { _.as[Map[String, _root_.org.joda.time.LocalDate]] }
    implicit val columnToSeqDateTime: Column[Seq[_root_.org.joda.time.DateTime]] = Util.parser { _.as[Seq[_root_.org.joda.time.DateTime]] }
    implicit val columnToMapDateTime: Column[Map[String, _root_.org.joda.time.DateTime]] = Util.parser { _.as[Map[String, _root_.org.joda.time.DateTime]] }
    implicit val columnToSeqBigDecimal: Column[Seq[BigDecimal]] = Util.parser { _.as[Seq[BigDecimal]] }
    implicit val columnToMapBigDecimal: Column[Map[String, BigDecimal]] = Util.parser { _.as[Map[String, BigDecimal]] }
    implicit val columnToSeqJsObject: Column[Seq[_root_.play.api.libs.json.JsObject]] = Util.parser { _.as[Seq[_root_.play.api.libs.json.JsObject]] }
    implicit val columnToMapJsObject: Column[Map[String, _root_.play.api.libs.json.JsObject]] = Util.parser { _.as[Map[String, _root_.play.api.libs.json.JsObject]] }
    implicit val columnToSeqJsValue: Column[Seq[_root_.play.api.libs.json.JsValue]] = Util.parser { _.as[Seq[_root_.play.api.libs.json.JsValue]] }
    implicit val columnToMapJsValue: Column[Map[String, _root_.play.api.libs.json.JsValue]] = Util.parser { _.as[Map[String, _root_.play.api.libs.json.JsValue]] }
    implicit val columnToSeqString: Column[Seq[String]] = Util.parser { _.as[Seq[String]] }
    implicit val columnToMapString: Column[Map[String, String]] = Util.parser { _.as[Map[String, String]] }
    implicit val columnToSeqUUID: Column[Seq[_root_.java.util.UUID]] = Util.parser { _.as[Seq[_root_.java.util.UUID]] }
    implicit val columnToMapUUID: Column[Map[String, _root_.java.util.UUID]] = Util.parser { _.as[Map[String, _root_.java.util.UUID]] }
  }

}