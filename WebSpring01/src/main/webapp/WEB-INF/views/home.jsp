<%@page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<h1>
	Hello world!  
</h1>

<P>  The time on the server is ${serverTime}. </P>
<P>홍길동의 스프링 홈</P>
<!-- <img src = "resources/com.jpg"/> -->
<img src="img/com.jpg">

<!-- 

		1.WEB-INF 에 lib 폴더 생성
		생성한 폴더 안에 jdbc8.jar 복사
		
		2.pom.xml에 dependency 추가
		ojdbc8
		
		<dependency>
		<groupId>com.oracle</groupId>
		<artifactId>ojdbc8</artifactId>
		<version>18.0.0</version>
		<scope>system</scope>
		<systemPath>${basedir}/src/main/webapp/WEB-INF/lib/ojdbc8.jar</systemPath>
		</dependency>   
		
		https://mvnrepository.com/artifact/org.springframework/spring-jdbc
		
		<dependency>
		    <groupId>org.springframework</groupId>
		    <artifactId>spring-jdbc</artifactId>
		    <version>5.2.10.RELEASE</version>
		</dependency>
		
		
		3.servlet-context.xml에 db 정보 추가
		
		오라클 드라이브, 서버위치, 계정, 비밀번호
		
		<beans:bean name="dataSource" class="org.springframework.jdbc.datasource.DriverManagerDataSource">
			<beans:property name="driverClassName" value="oracle.jdbc.driver.OracleDriver"></beans:property>
			<beans:property name="url" value="jdbc:oracle:thin:@localhost:1521:xe"></beans:property>
			<beans:property name="username" value="c##scott"></beans:property>
			<beans:property name="password" value="tiger"></beans:property>
		</beans:bean>

 -->