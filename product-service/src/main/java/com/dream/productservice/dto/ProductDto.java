package com.dream.productservice.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class ProductDto {
	private int proNo;	//��ǰ ��ȣ
	private String proName;	//��ǰ �̸�
	private double proLimit;	// ���� �ѵ�
	private String description;	// ��ǰ ����
	private int term;	//���� �Ⱓ
}