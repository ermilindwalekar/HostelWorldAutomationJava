package com.test.assignment;

import java.io.IOException;

import io.restassured.RestAssured;
import io.restassured.http.Header;
import io.restassured.http.Method;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class CreateGist {

	public static void main(String[] args) throws IOException {
		
		String body="{\r\n" + 
				"  \"description\": \"Hello World Examples\",\r\n" + 
				"  \"public\": true,\r\n" + 
				"  \"files\": {\r\n" + 
				"    \"hello_world.rb\": {\r\n" + 
				"      \"content\": \"class HelloWorld\\n   def initialize(name)\\n      @name = name.capitalize\\n   end\\n   def sayHi\\n      puts \\\"Hello !\\\"\\n   end\\nend\\n\\nhello = HelloWorld.new(\\\"World\\\")\\nhello.sayHi\"\r\n" + 
				"    },\r\n" + 
				"    \"hello_world.py\": {\r\n" + 
				"      \"content\": \"class HelloWorld:\\n\\n    def __init__(self, name):\\n        self.name = name.capitalize()\\n       \\n    def sayHi(self):\\n        print \\\"Hello \\\" + self.name + \\\"!\\\"\\n\\nhello = HelloWorld(\\\"world\\\")\\nhello.sayHi()\"\r\n" + 
				"    },\r\n" + 
				"    \"hello_world_ruby.txt\": {\r\n" + 
				"      \"content\": \"Run `ruby hello_world.rb` to print Hello World\"\r\n" + 
				"    },\r\n" + 
				"    \"hello_world_python.txt\": {\r\n" + 
				"      \"content\": \"Run `python hello_world.py` to print Hello World\"\r\n" + 
				"    }\r\n" + 
				"  }\r\n" + 
				"}";
		RestAssured.baseURI ="https://api.github.com/";
		RequestSpecification httprequest = RestAssured.given();
		Header headers = new Header("Authorization", "token "+ Token.getTooken());
		
		httprequest.header(headers);
		
		httprequest.contentType("application/json");
		httprequest.body(body);
		Response response = httprequest.request(Method.POST,"/gists");
		
			System.out.println("Response Code------>"+response.getStatusCode());
			System.out.println("Response Status---->"+response.getStatusLine());

	}

}
