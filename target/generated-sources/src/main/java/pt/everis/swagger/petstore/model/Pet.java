package pt.everis.swagger.petstore.model;

import java.util.Objects;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonValue;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import java.util.ArrayList;
import java.util.List;
import javax.validation.Valid;
import javax.validation.constraints.*;

/**
 * Pet
 */
@javax.annotation.Generated(value = "io.swagger.codegen.languages.SpringCodegen", date = "2019-11-08T14:50:08.605Z")

public class Pet   {
  @JsonProperty("id")
  private Long id = null;

  @JsonProperty("race")
  private String race = null;

  @JsonProperty("name")
  private String name = null;

  @JsonProperty("photos")
  private List<String> photos = null;

  /**
   * pet status in the store
   */
  public enum StatusEnum {
    AVAILABLE("available"),
    
    PENDING("pending"),
    
    SOLD("sold");

    private String value;

    StatusEnum(String value) {
      this.value = value;
    }

    @Override
    @JsonValue
    public String toString() {
      return String.valueOf(value);
    }

    @JsonCreator
    public static StatusEnum fromValue(String text) {
      for (StatusEnum b : StatusEnum.values()) {
        if (String.valueOf(b.value).equals(text)) {
          return b;
        }
      }
      return null;
    }
  }

  @JsonProperty("status")
  private StatusEnum status = null;

  @JsonProperty("price")
  private Long price = null;

  public Pet id(Long id) {
    this.id = id;
    return this;
  }

   /**
   * Get id
   * @return id
  **/
  @ApiModelProperty(value = "")


  public Long getId() {
    return id;
  }

  public void setId(Long id) {
    this.id = id;
  }

  public Pet race(String race) {
    this.race = race;
    return this;
  }

   /**
   * Get race
   * @return race
  **/
  @ApiModelProperty(value = "")


  public String getRace() {
    return race;
  }

  public void setRace(String race) {
    this.race = race;
  }

  public Pet name(String name) {
    this.name = name;
    return this;
  }

   /**
   * Get name
   * @return name
  **/
  @ApiModelProperty(example = "doggie", required = true, value = "")
  @NotNull


  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public Pet photos(List<String> photos) {
    this.photos = photos;
    return this;
  }

  public Pet addPhotosItem(String photosItem) {
    if (this.photos == null) {
      this.photos = new ArrayList<String>();
    }
    this.photos.add(photosItem);
    return this;
  }

   /**
   * Get photos
   * @return photos
  **/
  @ApiModelProperty(value = "")


  public List<String> getPhotos() {
    return photos;
  }

  public void setPhotos(List<String> photos) {
    this.photos = photos;
  }

  public Pet status(StatusEnum status) {
    this.status = status;
    return this;
  }

   /**
   * pet status in the store
   * @return status
  **/
  @ApiModelProperty(value = "pet status in the store")


  public StatusEnum getStatus() {
    return status;
  }

  public void setStatus(StatusEnum status) {
    this.status = status;
  }

  public Pet price(Long price) {
    this.price = price;
    return this;
  }

   /**
   * Get price
   * @return price
  **/
  @ApiModelProperty(value = "")


  public Long getPrice() {
    return price;
  }

  public void setPrice(Long price) {
    this.price = price;
  }


  @Override
  public boolean equals(java.lang.Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    Pet pet = (Pet) o;
    return Objects.equals(this.id, pet.id) &&
        Objects.equals(this.race, pet.race) &&
        Objects.equals(this.name, pet.name) &&
        Objects.equals(this.photos, pet.photos) &&
        Objects.equals(this.status, pet.status) &&
        Objects.equals(this.price, pet.price);
  }

  @Override
  public int hashCode() {
    return Objects.hash(id, race, name, photos, status, price);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class Pet {\n");
    
    sb.append("    id: ").append(toIndentedString(id)).append("\n");
    sb.append("    race: ").append(toIndentedString(race)).append("\n");
    sb.append("    name: ").append(toIndentedString(name)).append("\n");
    sb.append("    photos: ").append(toIndentedString(photos)).append("\n");
    sb.append("    status: ").append(toIndentedString(status)).append("\n");
    sb.append("    price: ").append(toIndentedString(price)).append("\n");
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

