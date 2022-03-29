package com.dream.loanService.domain;

import java.util.Date;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class loanProductVO {
	
	private int proNo;	//��ǰ ��ȣ
	private String proName;	//��ǰ �̸�
	private double proLimit;	// ���� �ѵ�
	private String description;	// ��ǰ ����
	private int term;	//���� �Ⱓ
}
