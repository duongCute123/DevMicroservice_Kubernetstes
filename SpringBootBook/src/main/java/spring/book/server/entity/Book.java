package spring.book.server.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "books")
public class Book {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int id;
	private String tenSach;
	private int soLuong;
	private float giaSach;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getTenSach() {
		return tenSach;
	}

	public void setTenSach(String tenSach) {
		this.tenSach = tenSach;
	}

	public int getSoLuong() {
		return soLuong;
	}

	public void setSoLuong(int soLuong) {
		this.soLuong = soLuong;
	}

	public float getGiaSach() {
		return giaSach;
	}

	public void setGiaSach(float giaSach) {
		this.giaSach = giaSach;
	}

	public Book(int id, String tenSach, int soLuong, float giaSach) {
		super();
		this.id = id;
		this.tenSach = tenSach;
		this.soLuong = soLuong;
		this.giaSach = giaSach;
	}

	public Book() {
		super();
	}

}
