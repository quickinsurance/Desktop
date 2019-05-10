package ManagedBeans;

import java.io.Serializable;
import javax.faces.bean.ApplicationScoped;
import javax.faces.bean.ManagedBean;
import javax.faces.event.ValueChangeEvent;
import entities.Property.item;
import entities.Property.marque;
import entities.Property.option_quote;
@ManagedBean(name = "data")
@ApplicationScoped
public class Data implements Serializable {
	private static final long serialVersionUID = 1L;
	marque[] marques;
	Object c;
	public item[] getItems() {return item.values();}
	public marque[] getMarques() {return marques;}	
	public option_quote[] getOptions() {return option_quote.values();}	
	public void setMarques(ValueChangeEvent vc) {
		 c = vc.getNewValue();
		if (c.equals("MobilePhone")) {
			
			marques[0]=marque.Amazon;
			marques[1]=marque.Apple;
			marques[2]=marque.BlackBerry;
			marques[3]=marque.Google;
			marques[4]=marque.Honor;
			marques[5]=marque.HTC;
			marques[6]=marque.Huawei;
			marques[7]=marque.LG;
			marques[8]=marque.Microsoft;
			marques[9]=marque.Motorola;
			marques[10]=marque.Nokia;
			marques[11]=marque.OnePlus;
			marques[12]=marque.Razor;
			marques[13]=marque.Samsung;
			marques[14]=marque.Sony;
		}
		if (c.equals("Laptop")) {
			marques[0]=marque.Acer;
			marques[1]=marque.Advent;
			marques[2]=marque.Apple;
			marques[3]=marque.Asus;
			marques[4]=marque.Dell;
			marques[5]=marque.FujitsuSiemens;
			marques[6]=marque.Gigabyte;
			marques[7]=marque.Hp;
			marques[8]=marque.Lenovo;
			marques[9]=marque.Medion;
			marques[10]=marque.Microsoft;
			marques[11]=marque.PackardBell;
			marques[12]=marque.Samsung;
			marques[13]=marque.SonyVaio;
			marques[14]=marque.Toshiba;

		}
		if (c.equals("EReader")) {
			marques[0]=marque.Amazon;
			marques[1]=marque.Mio;
			marques[2]=marque.Sony;
		}
		if (c.equals("Games")) {
			marques[0]=marque.Archos;
			marques[1]=marque.Microsoft;
			marques[2]=marque.Nintendo;
			marques[3]=marque.Sony;

		}
		if (c.equals("MP3")) {
			marques[0]=marque.Apple;
			marques[1]=marque.Cowon;
			marques[2]=marque.Creative;
			marques[3]=marque.Microsoft;
			marques[4]=marque.Philips;
			marques[5]=marque.Sony;
			marques[6]=marque.Yamaha;
			marques[7]=marque.Zune;

		}
		if (c.equals("Camera")) {
			marques[0]=marque.Canon;
			marques[1]=marque.Fuji;
			marques[2]=marque.FujiFilm;
			marques[3]=marque.GoPro;
			marques[4]=marque.Kodak;
			marques[5]=marque.Leica;
			marques[6]=marque.Lomography;
			marques[7]=marque.Nikon;
			marques[8]=marque.Olympus;
			marques[9]=marque.Panasonic;
			marques[10]=marque.Pentax;
			marques[11]=marque.Samsung;
			marques[12]=marque.Sony;

		}
		if (c.equals("DesktopPC")) {
			marques[0]=marque.Acer;
			marques[1]=marque.Apple;
			marques[2]=marque.Asus;
			marques[3]=marque.Dell;
			marques[4]=marque.Gigabyte;
			marques[5]=marque.Hp;
			marques[6]=marque.Lenovo;
			marques[7]=marque.Microsoft;
			marques[8]=marque.Samsung;
			marques[9]=marque.Toshiba;
		}
	}

}
