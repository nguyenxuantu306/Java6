package com.poly.bean;

import java.io.Serializable;

import java.time.LocalDate;
import java.util.List;



import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.Table;
import jakarta.persistence.Temporal;
import jakarta.persistence.TemporalType;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Entity
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "Accounts")
public class Account implements Serializable {

	@Id	
	String Id;
	@NotNull(message = "Không được để trống Tài khoản")
	@Pattern(regexp = "^[a-zA-Z0-9](_(?!(\\.|_))|\\.(?!(_|\\.))|[a-zA-Z0-9]){0,}[a-zA-Z0-9]$", message = "Tài khoản không đúng định dạng")
	@Size(min = 6, max = 18, message = "Tài khoản phải có độ dài từ 6 - 18 ký tự")
	String username;
	
	@NotBlank(message = "Không được để trống Mật khẩu")
	@Size(min = 4, max = 50, message = "Mật khẩu phải có độ dài từ 4 - 50 ký tự")
	String Password;
	
	@NotNull(message = "Không được để trống Họ tên")
	@Pattern(regexp = "^\\S([a-zA-Z\\xC0-\\uFFFF]{0,}[ \\-\\']{0,}){1,}$", message = "Họ tên không đúng định dạng")
	@Size(min = 4, max = 50, message = "Họ tên phải có độ dài từ 4 - 50 ký tự")
	String Fullname;
	
	@NotNull(message = "Không được để trống Email")
	@Pattern(regexp = "^\\w+([\\.-]?\\w+)*@\\w+([\\.-]?\\w+)*(\\.\\w{2,3})+$", message = "Email không đúng dịnh dạng")
	String Email;
	
	String Photo;
	
	Boolean Gender;
	
	@NotNull(message = "Không được để trống Địa chỉ")
	@Pattern(regexp = "^\\S([a-zA-Z0-9\\xC0-\\uFFFF\\.]{0,}[ \\-\\' \\.-]{0,}){1,}$", message = "Địa chỉ không đúng định dạng")
	@Size(min = 4, max = 100, message = "Địa chỉ phải có độ dài từ 4 - 100 ký tự")
	String Address;
	
	@NotBlank(message = "Không được để trống số điện thoại")
	@Pattern(regexp = "(84|0[3|5|7|8|9])+([0-9]{8})\\b", message = "Số điện thoại không đúng định dạng")
	String Phone;
	
	@Temporal(TemporalType.DATE)
	@Column(name = "Date")
	LocalDate date;
	
	@JsonIgnore
	@OneToMany(mappedBy = "account")
	List<Order> order;
	
	@JsonIgnore
	@OneToMany(mappedBy = "account", fetch = FetchType.EAGER)
	List<Account_roles> accountroles;
}
