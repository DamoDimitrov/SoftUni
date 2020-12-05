package softuni.exam.models.dtos.xmls;

import org.springframework.beans.factory.annotation.Autowired;
import softuni.exam.config.LocalDateTimeAdapter;
import softuni.exam.models.dtos.jsons.CarImportDto;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.adapters.XmlJavaTypeAdapter;
import java.math.BigDecimal;
import java.time.LocalDateTime;

@XmlRootElement(name = "offer")
@XmlAccessorType(XmlAccessType.FIELD)
public class OfferImportDto {

    @XmlElement
    private String description;
    @XmlElement
    private BigDecimal price;
    @XmlElement(name = "added_on")
    @XmlJavaTypeAdapter(LocalDateTimeAdapter.class)
    private LocalDateTime addedOn;
    @XmlElement(name = "has_gold_status")
    private boolean hasGoldStatus;
    @XmlElement
    private CarImportXMLDto car;
    @XmlElement
    private SellerImportXMLDto seller;

    @Autowired
    public OfferImportDto(String description, BigDecimal price, LocalDateTime addedOn, boolean hasGoldStatus, CarImportXMLDto car, SellerImportXMLDto seller) {
        this.description = description;
        this.price = price;
        this.addedOn = addedOn;
        this.hasGoldStatus = hasGoldStatus;
        this.car = car;
        this.seller = seller;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }

    public LocalDateTime getAddedOn() {
        return addedOn;
    }

    public void setAddedOn(LocalDateTime addedOn) {
        this.addedOn = addedOn;
    }

    public boolean isHasGoldStatus() {
        return hasGoldStatus;
    }

    public void setHasGoldStatus(boolean hasGoldStatus) {
        this.hasGoldStatus = hasGoldStatus;
    }

    public CarImportXMLDto getCar() {
        return car;
    }

    public void setCar(CarImportXMLDto car) {
        this.car = car;
    }

    public SellerImportXMLDto getSeller() {
        return seller;
    }

    public void setSeller(SellerImportXMLDto seller) {
        this.seller = seller;
    }
}
