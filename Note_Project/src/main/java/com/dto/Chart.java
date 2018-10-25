package com.dto;

import org.apache.ibatis.type.Alias;

@Alias("Chart")
public class Chart {

	private int Seoul;
	private int Gyeonggi;
	private int Gangwon;
	private int Chungcheongbuk;
	private int Chungcheongnam;
	private int Jeollabuk;
	private int Jeollanam;
	private int Gyeongsangbuk;
	private int Gyeongsangnam;
	private int Cheju;
	
	public Chart() { }
	public Chart(int seoul, int gyeonggi, int gangwon, int chungcheongbuk, int chungcheongnam, int jeollabuk,
			int jeollanam, int gyeongsangbuk, int gyeongsangnam, int cheju) {
		Seoul = seoul;
		Gyeonggi = gyeonggi;
		Gangwon = gangwon;
		Chungcheongbuk = chungcheongbuk;
		Chungcheongnam = chungcheongnam;
		Jeollabuk = jeollabuk;
		Jeollanam = jeollanam;
		Gyeongsangbuk = gyeongsangbuk;
		Gyeongsangnam = gyeongsangnam;
		Cheju = cheju;
	}
	
	public int getSeoul() {
		return Seoul;
	}
	public void setSeoul(int seoul) {
		Seoul = seoul;
	}
	public int getGyeonggi() {
		return Gyeonggi;
	}
	public void setGyeonggi(int gyeonggi) {
		Gyeonggi = gyeonggi;
	}
	public int getGangwon() {
		return Gangwon;
	}
	public void setGangwon(int gangwon) {
		Gangwon = gangwon;
	}
	public int getChungcheongbuk() {
		return Chungcheongbuk;
	}
	public void setChungcheongbuk(int chungcheongbuk) {
		Chungcheongbuk = chungcheongbuk;
	}
	public int getChungcheongnam() {
		return Chungcheongnam;
	}
	public void setChungcheongnam(int chungcheongnam) {
		Chungcheongnam = chungcheongnam;
	}
	public int getJeollabuk() {
		return Jeollabuk;
	}
	public void setJeollabuk(int jeollabuk) {
		Jeollabuk = jeollabuk;
	}
	public int getJeollanam() {
		return Jeollanam;
	}
	public void setJeollanam(int jeollanam) {
		Jeollanam = jeollanam;
	}
	public int getGyeongsangbuk() {
		return Gyeongsangbuk;
	}
	public void setGyeongsangbuk(int gyeongsangbuk) {
		Gyeongsangbuk = gyeongsangbuk;
	}
	public int getGyeongsangnam() {
		return Gyeongsangnam;
	}
	public void setGyeongsangnam(int gyeongsangnam) {
		Gyeongsangnam = gyeongsangnam;
	}
	public int getCheju() {
		return Cheju;
	}
	public void setCheju(int cheju) {
		Cheju = cheju;
	}
	
	
	
}
