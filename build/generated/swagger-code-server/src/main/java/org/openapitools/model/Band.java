package org.openapitools.model;

import java.util.Objects;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonCreator;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;
import org.openapitools.model.Member;
import org.openapitools.model.Status;
import javax.validation.Valid;
import javax.validation.constraints.*;

/**
 * Band
 */
@ApiModel(description = "Band")

public class Band   {
  @JsonProperty("id")
  private UUID id;

  @JsonProperty("name")
  private String name;

  @JsonProperty("creation")
  private LocalDate creation;

  @JsonProperty("members")
  @Valid
  private List<Member> members = null;

  @JsonProperty("status")
  private Status status = null;

  @JsonProperty("create_at")
  private LocalDate createAt;

  @JsonProperty("update_at")
  private LocalDate updateAt;

  public Band id(UUID id) {
    this.id = id;
    return this;
  }

  /**
   * Band id
   * @return id
  */
  @ApiModelProperty(value = "Band id")

  @Valid

  public UUID getId() {
    return id;
  }

  public void setId(UUID id) {
    this.id = id;
  }

  public Band name(String name) {
    this.name = name;
    return this;
  }

  /**
   * Band name
   * @return name
  */
  @ApiModelProperty(value = "Band name")


  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public Band creation(LocalDate creation) {
    this.creation = creation;
    return this;
  }

  /**
   * Band date creation
   * @return creation
  */
  @ApiModelProperty(value = "Band date creation")

  @Valid

  public LocalDate getCreation() {
    return creation;
  }

  public void setCreation(LocalDate creation) {
    this.creation = creation;
  }

  public Band members(List<Member> members) {
    this.members = members;
    return this;
  }

  public Band addMembersItem(Member membersItem) {
    if (this.members == null) {
      this.members = new ArrayList<>();
    }
    this.members.add(membersItem);
    return this;
  }

  /**
   * Get members
   * @return members
  */
  @ApiModelProperty(value = "")

  @Valid

  public List<Member> getMembers() {
    return members;
  }

  public void setMembers(List<Member> members) {
    this.members = members;
  }

  public Band status(Status status) {
    this.status = status;
    return this;
  }

  /**
   * Get status
   * @return status
  */
  @ApiModelProperty(value = "")

  @Valid

  public Status getStatus() {
    return status;
  }

  public void setStatus(Status status) {
    this.status = status;
  }

  public Band createAt(LocalDate createAt) {
    this.createAt = createAt;
    return this;
  }

  /**
   * Entry date creation
   * @return createAt
  */
  @ApiModelProperty(value = "Entry date creation")

  @Valid

  public LocalDate getCreateAt() {
    return createAt;
  }

  public void setCreateAt(LocalDate createAt) {
    this.createAt = createAt;
  }

  public Band updateAt(LocalDate updateAt) {
    this.updateAt = updateAt;
    return this;
  }

  /**
   * Entry date update
   * @return updateAt
  */
  @ApiModelProperty(value = "Entry date update")

  @Valid

  public LocalDate getUpdateAt() {
    return updateAt;
  }

  public void setUpdateAt(LocalDate updateAt) {
    this.updateAt = updateAt;
  }


  @Override
  public boolean equals(java.lang.Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    Band band = (Band) o;
    return Objects.equals(this.id, band.id) &&
        Objects.equals(this.name, band.name) &&
        Objects.equals(this.creation, band.creation) &&
        Objects.equals(this.members, band.members) &&
        Objects.equals(this.status, band.status) &&
        Objects.equals(this.createAt, band.createAt) &&
        Objects.equals(this.updateAt, band.updateAt);
  }

  @Override
  public int hashCode() {
    return Objects.hash(id, name, creation, members, status, createAt, updateAt);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class Band {\n");
    
    sb.append("    id: ").append(toIndentedString(id)).append("\n");
    sb.append("    name: ").append(toIndentedString(name)).append("\n");
    sb.append("    creation: ").append(toIndentedString(creation)).append("\n");
    sb.append("    members: ").append(toIndentedString(members)).append("\n");
    sb.append("    status: ").append(toIndentedString(status)).append("\n");
    sb.append("    createAt: ").append(toIndentedString(createAt)).append("\n");
    sb.append("    updateAt: ").append(toIndentedString(updateAt)).append("\n");
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

