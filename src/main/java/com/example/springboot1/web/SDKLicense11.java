package com.example.springboot1.web;

public class SDKLicense11 {
	static{
		System.load(
			System.getProperty("user.dir") 
			+ "/intellif/utils/libSDKLicense.so"
		);
	}
	
	public native String CipherLicense(
		String template,
		String privateKey,
		String signature, 
		String expireDate, 
		String funcType 
		);
	public static void main(String[] args) {
		
		SDKLicense11 sdk = new SDKLicense11();
		String dir=System.getProperty("user.dir");
		
		String template=dir+"/template/license.ini";
		String privateKey="M1RpEVmv7zDrzHQI";
		String signature="a83a5335f5e72d8f47fa13770ba895b0";
		String expireDate="2018-12-09";
		String funcType="1";

		String license1=sdk.CipherLicense(
		template,
		privateKey,
		signature, 
		expireDate, 
		funcType 
		);
		System.out.println(license1);

		
		template=dir+"/template/license.ini";
		privateKey="";
		signature="4af695d6c2475585e0afc884254c539d";
		expireDate="2018-05-30sdfsdddddddddddddfsd";
		funcType="a";
		String license2=sdk.CipherLicense(
		template,
		privateKey,
		signature, 
		expireDate, 
		funcType 
		);
		System.out.println(license2);	
		
		template=dir+"/template/license.ini";
		privateKey="";
		signature="7777777777777777777778888888888888";
		expireDate="2018-05-30sdfsdddddddddddddfsd";
		funcType="a";
		String license3=sdk.CipherLicense(
		template,
		privateKey,
		signature, 
		expireDate, 
		funcType 
		);
		System.out.println(license3);			
	}
}
