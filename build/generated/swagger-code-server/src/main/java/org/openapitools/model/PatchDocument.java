package org.openapitools.model;

import java.util.Objects;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonValue;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import javax.validation.Valid;
import javax.validation.constraints.*;

/**
 * A JSONPatch document as defined by RFC 6902
 */
@ApiModel(description = "A JSONPatch document as defined by RFC 6902")

public class PatchDocument   {
  /**
   * The operation to be performed
   */
  public enum OpEnum {
    ADD("add"),
    
    REMOVE("remove"),
    
    REPLACE("replace"),
    
    MOVE("move"),
    
    COPY("copy"),
    
    TEST("test");

    private String value;

    OpEnum(String value) {
      this.value = value;
    }

    @Override
    @JsonValue
    public String toString() {
      return String.valueOf(value);
    }

    @JsonCreator
    public static OpEnum fromValue(String text) {
      for (OpEnum b : OpEnum.values()) {
        if (String.valueOf(b.value).equals(text)) {
          return b;
        }
      }
      throw new IllegalArgumentException("Unexpected value '" + text + "'");
    }
  }

  @JsonProperty("op")
  private OpEnum op;

  @JsonProperty("path")
  private String path;

  @JsonProperty("value")
  private Object value = null;

  @JsonProperty("from")
  private String from;

  public PatchDocument op(OpEnum op) {
    this.op = op;
    return this;
  }

  /**
   * The operation to be performed
   * @return op
  */
  @ApiModelProperty(required = true, value = "The operation to be performed")
  @NotNull


  public OpEnum getOp() {
    return op;
  }

  public void setOp(OpEnum op) {
    this.op = op;
  }

  public PatchDocument path(String path) {
    this.path = path;
    return this;
  }

  /**
   * A JSON-Pointer
   * @return path
  */
  @ApiModelProperty(required = true, value = "A JSON-Pointer")
  @NotNull


  public String getPath() {
    return path;
  }

  public void setPath(String path) {
    this.path = path;
  }

  public PatchDocument value(Object value) {
    this.value = value;
    return this;
  }

  /**
   * The value to be used within the operations.
   * @return value
  */
  @ApiModelProperty(value = "The value to be used within the operations.")


  public Object getValue() {
    return value;
  }

  public void setValue(Object value) {
    this.value = value;
  }

  public PatchDocument from(String from) {
    this.from = from;
    return this;
  }

  /**
   * A string containing a JSON Pointer value.
   * @return from
  */
  @ApiModelProperty(value = "A string containing a JSON Pointer value.")


  public String getFrom() {
    return from;
  }

  public void setFrom(String from) {
    this.from = from;
  }


  @Override
  public boolean equals(java.lang.Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    PatchDocument patchDocument = (PatchDocument) o;
    return Objects.equals(this.op, patchDocument.op) &&
        Objects.equals(this.path, patchDocument.path) &&
        Objects.equals(this.value, patchDocument.value) &&
        Objects.equals(this.from, patchDocument.from);
  }

  @Override
  public int hashCode() {
    return Objects.hash(op, path, value, from);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class PatchDocument {\n");
    
    sb.append("    op: ").append(toIndentedString(op)).append("\n");
    sb.append("    path: ").append(toIndentedString(path)).append("\n");
    sb.append("    value: ").append(toIndentedString(value)).append("\n");
    sb.append("    from: ").append(toIndentedString(from)).append("\n");
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

