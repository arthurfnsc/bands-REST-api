package org.openapitools.model;

import java.util.Objects;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonCreator;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import javax.validation.Valid;
import javax.validation.constraints.*;

/**
 * Error
 */
@ApiModel(description = "Error")

public class Error   {
  @JsonProperty("http_code")
  private Integer httpCode;

  @JsonProperty("http_message")
  private String httpMessage;

  @JsonProperty("description")
  private String description;

  public Error httpCode(Integer httpCode) {
    this.httpCode = httpCode;
    return this;
  }

  /**
   * HTTP Code. ex:  400, 401, 404.
   * @return httpCode
  */
  @ApiModelProperty(value = "HTTP Code. ex:  400, 401, 404.")


  public Integer getHttpCode() {
    return httpCode;
  }

  public void setHttpCode(Integer httpCode) {
    this.httpCode = httpCode;
  }

  public Error httpMessage(String httpMessage) {
    this.httpMessage = httpMessage;
    return this;
  }

  /**
   * HTTP BandStatus Message. ex: Bad Request, Unauthorized, Not Found.
   * @return httpMessage
  */
  @ApiModelProperty(value = "HTTP BandStatus Message. ex: Bad Request, Unauthorized, Not Found.")


  public String getHttpMessage() {
    return httpMessage;
  }

  public void setHttpMessage(String httpMessage) {
    this.httpMessage = httpMessage;
  }

  public Error description(String description) {
    this.description = description;
    return this;
  }

  /**
   * Error description.
   * @return description
  */
  @ApiModelProperty(value = "Error description.")


  public String getDescription() {
    return description;
  }

  public void setDescription(String description) {
    this.description = description;
  }


  @Override
  public boolean equals(java.lang.Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    Error error = (Error) o;
    return Objects.equals(this.httpCode, error.httpCode) &&
        Objects.equals(this.httpMessage, error.httpMessage) &&
        Objects.equals(this.description, error.description);
  }

  @Override
  public int hashCode() {
    return Objects.hash(httpCode, httpMessage, description);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class Error {\n");
    
    sb.append("    httpCode: ").append(toIndentedString(httpCode)).append("\n");
    sb.append("    httpMessage: ").append(toIndentedString(httpMessage)).append("\n");
    sb.append("    description: ").append(toIndentedString(description)).append("\n");
    sb.append("}");
    return sb.toString();
  }

  /**
   * Convert the given object to string with each line indented by 4 spaces
   * (except the first line).
   */
  private String toIndentedString(java.lang.Object o) {
    if (o == null) {
      return "null";
    }
    return o.toString().replace("\n", "\n    ");
  }
}

