plugins {
	java
	id("org.springframework.boot") version "3.5.0"
	id("io.spring.dependency-management") version "1.1.7"
	
    kotlin("jvm") version "1.9.0"
    kotlin("plugin.spring") version "1.9.0"
}

group = "com.example"
version = "0.0.1-SNAPSHOT"

java {
	toolchain {
		languageVersion = JavaLanguageVersion.of(17)
	}
}

configurations {
	compileOnly {
		extendsFrom(configurations.annotationProcessor.get())
	}
}

repositories {
	mavenCentral()
}

dependencies {
	implementation("org.springframework.boot:spring-boot-starter-data-jdbc")
	// Spring Boot starter
	implementation("org.springframework.boot:spring-boot-starter-web")
	// Spring Boot Security
	implementation("org.springframework.boot:spring-boot-starter-security")
	// Thymeleaf
	implementation("org.springframework.boot:spring-boot-starter-thymeleaf")
	// MyBatis Spring Boot Starter
    implementation("org.mybatis.spring.boot:mybatis-spring-boot-starter:3.0.4")
	// PostgreSQL JDBC Driver
	runtimeOnly("org.postgresql:postgresql")
	// Kotlin dependencies (if applicable)
    implementation("org.jetbrains.kotlin:kotlin-reflect")
    implementation("org.jetbrains.kotlin:kotlin-stdlib-jdk8")
    
	developmentOnly("org.springframework.boot:spring-boot-devtools")
	
	//lombok
    //compileOnly("org.projectlombok:lombok:1.18.30")
    //annotationProcessor("org.projectlombok:lombok:1.18.30")
    compileOnly("org.projectlombok:lombok")
    annotationProcessor("org.projectlombok:lombok")
	
	// Test
    testImplementation("org.springframework.boot:spring-boot-starter-test")
	testRuntimeOnly("org.junit.platform:junit-platform-launcher")
	
	// webconfig
    implementation("com.fasterxml.jackson.module:jackson-module-kotlin")
    
    //implementation("org.springframework.boot:spring-boot-starter-web") 와 충돌하기 때문에 webclient를 쓰려면 일부만 추려서 가져오도록 한다.
    //implementation("org.springframework.boot:spring-boot-starter-webflux")
    implementation("org.springframework:spring-webflux")
    
    //batch
    implementation("org.springframework.boot:spring-boot-starter-batch")
    
    implementation("p6spy:p6spy:3.9.1")
}

tasks.withType<Test> {
	useJUnitPlatform()
}


tasks.withType<org.jetbrains.kotlin.gradle.tasks.KotlinCompile> {
    kotlinOptions {
        freeCompilerArgs = listOf("-Xjsr305=strict") // 자바 null 애노테이션 엄격 적용
        jvmTarget = "17" // Kotlin 컴파일 시 JDK 17 타겟으로 맞춤
    }
}
