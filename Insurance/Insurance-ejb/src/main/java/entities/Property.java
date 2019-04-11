package entities;

import java.io.Serializable;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;



@Entity
@Table(name = "Property")
public class Property implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue( strategy = GenerationType.IDENTITY )
	@Column(name="property_ID")
	private int id;
	@ManyToOne(cascade = {CascadeType.REMOVE,CascadeType.PERSIST})
	EquipmentQuote EquipmentQuote;
	@Column(name = "Condition_equipment", nullable = false)
	private String condition_equipment;
	private float prime;
	@Column(nullable = false)
	@Enumerated(EnumType.STRING)
	private type_item type_item;
	public  enum type_item{electronic("electronic"),
			furniture("furniture");
			private type_item (String name){} 
		}
	@Column(nullable = false)
	@Enumerated(EnumType.STRING)
	private item item;
	public enum  item{MobilePhone("electronic"),
			Laptop("Laptop"),
			EReader("EReader"),
			MP3("MP3"),
			Games("Games"),
			Camera("Camera"),
			DesktopPC("DesktopPC"),
			homeAppliance("homeAppliance");
			private item (String name){} 
		}
	@Column(nullable = false)
	@Enumerated(EnumType.STRING)
	private marque marque;
	public enum marque{Amazon("Amazon"),
		Dell("Dell"),
		Disgo("Disgo"),
		Hp("Hp"),
		Lenovo("Lenovo"),
		Sony("Sony"),
		Toshiba("Toshiba"),
		Wacom("Wacom"),
		Advent("Advent"),
		FujitsuSiemens("FujitsuSiemens"),
		Gigabyte("Gigabyte"),
		Medion("Medion"),
		PackardBell("PackardBell"),
		SonyVaio("SonyVaio"),
		Mio("Mio"),
		Cowon("Cowon"),
		Creative("Creative"),
		Philips("Philips"),
		Yamaha("Yamaha"),
		Zune("Zune"),
		Nintendo("Nintendo"),
		GoPro("GoPro"),
		Canon("Canon"),
		Nikon("Nikon"),
		Fuji("Fuji"),
		FujiFilm("FujiFilm"),
		Kodak("Kodak"),
		Leica("Leica"),
		Lomography("Lomography"),
		Olympus("Olympus"),
		Panasonic("Panasonic"),
		Pentax("Pentax"),
		Acer("Acer"),
		Apple("Apple"),
		Archos("Archos"),
		Asus("Asus"),
		BarnesAndNoble("BarnesAndNoble"),
		BlackBerry("BlackBerry"),
		Google("Google"),
		Honor("Honor"),
		HTC("HTC"),
		Huawei("Huawei"),
		LG("LG"),
		Microsoft("Microsoft"),
		Motorola("Motorola"),
		Nokia("Nokia"),
		OnePlus("OnePlus"),
		Razor("Razor"),
		Samsung("Samsung");
		private marque (String name){} }
	@Column(nullable = false)
	private String Model;
	@Column(nullable = false)
	private Double value;
	@Column(nullable = false)
	@Enumerated(EnumType.STRING)
	private option_quote option_quote;
	public  enum option_quote {Standard("Standard"),
		Premium("Premium"),
		Ultimate("Ultimate");
		private option_quote (String name){} 
	}
	public String getCondition_equipment() {
		return condition_equipment;
	}
	public void setCondition_equipment(String condition_equipment) {
		this.condition_equipment = condition_equipment;
	}
	public type_item getType_item() {
		return type_item;
	}
	public void setType_item(type_item type_item) {
		this.type_item = type_item;
	}
	public item getItem() {
		return item;
	}
	public void setItem(item item) {
		this.item = item;
	}
	public marque getMarque() {
		return marque;
	}
	public void setMarque(marque marque) {
		this.marque = marque;
	}
	public String getModel() {
		return Model;
	}
	public void setModel(String model) {
		Model = model;
	}
	public Double getValue() {
		return value;
	}
	public void setValue(Double value) {
		this.value = value;
	}
	public EquipmentQuote getEquipmentQuote() {
		return EquipmentQuote;
	}
	public void setEquipmentQuote(EquipmentQuote equipmentQuote) {
		EquipmentQuote = equipmentQuote;
	}
	public int getId() {
		return id;
	}
	public option_quote getOption_quote() {
		return option_quote;
	}
	public void setOption_quote(option_quote option_quote) {
		this.option_quote = option_quote;
	}
	public float getPrime() {
		return prime;
	}
	public void setPrime(float prime) {
		this.prime = prime;
	}

	
	
}


