package org.openapitools.model;

import java.util.Objects;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonCreator;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import java.time.LocalDate;
import org.openapitools.model.Status;
import javax.validation.Valid;
import javax.validation.constraints.*;

/**
 * Request Post Band
 */
@ApiModel(description = "Request Post Band")

public class RequestPostBand   {
  @JsonProperty("name")
  private String name;

  @JsonProperty("creation")
  private LocalDate creation;

  @JsonProperty("status")
  private Status status = null;

  public RequestPostBand name(String name) {
    this.name = name;
    return this;
  }

  /**
   * Band name
   * @return name
  */
  @ApiModelProperty(required = true, value = "Band name")
  @NotNull


  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public RequestPostBand creation(LocalDate creation) {
    this.creation = creation;
    return this;
  }

  /**
   * Band date creation
   * @return creation
  */
  @ApiModelProperty(required = true, value = "Band date creation")
  @NotNull

  @Valid

  public LocalDate getCreation() {
    return creation;
  }

  public void setCreation(LocalDate creation) {
    this.creation = creation;
  }

  public RequestPostBand status(Status status) {
    this.status = status;
    return this;
  }

  /**
   * Get status
   * @return status
  */
  @ApiModelProperty(required = true, value = "")
  @NotNull

  @Valid

  public Status getStatus() {
    return status;
  }

  public void setStatus(Status status) {
    this.status = status;
  }


  @Override
  public boolean equals(java.lang.Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    RequestPostBand requestPostBand = (RequestPostBand) o;
    return Objects.equals(this.name, requestPostBand.name) &&
        Objects.equals(this.creation, requestPostBand.creation) &&
        Objects.equals(this.status, requestPostBand.status);
  }

  @Override
  public int hashCode() {
    return Objects.hash(name, creation, status);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class RequestPostBand {\n");
    
    sb.append("    name: ").append(toIndentedString(name)).append("\n");
    sb.append("    creation: ").append(toIndentedString(creation)).append("\n");
    sb.append("    status: ").append(toIndentedString(status)).append("\n");
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

