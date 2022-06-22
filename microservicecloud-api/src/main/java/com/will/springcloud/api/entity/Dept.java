package com.will.springcloud.api.entity;

import java.io.Serializable;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;

@SuppressWarnings("serial")
@AllArgsConstructor
@NoArgsConstructor
@Data
@Accessors(chain = true)
public class Dept implements Serializable{ // Dept(Entity) orm 在mysql中也有一個Dept(table) 為類表關係映射 //必須序列化
	private Long deptno; //主鍵
	private String dname; //部門名稱 
	private String db_source; //來自那個資料庫，因為微服務架構可以一個服務對應一個資料庫，同一個信息被儲存到不同資料庫

}
