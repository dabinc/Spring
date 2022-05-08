package com.care.ajax;

import java.util.ArrayList;
import java.util.HashMap;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
/**
 * 
 * @ResponseBody를 안써도 되며
 * 문제가 생겼을때 해당 mapping만 확인하면 되는 편리성을 가지기 때문에 사용한다.
 * -- 경계를 나누기 위해 주로 사용한다.
 * 
 * requestbody는 해당 ,jsp파일에서 넘겨들어오는 form (data)일때,
 * request param, pathvariable은 uri 끝에 달려오는 방식일때! 
 */
public class TestController {
	@GetMapping(value = "rest", produces = "application/json;charset=utf-8")
	public String get() {
		return "get 데이터 요청시에 사용한다";
	}
	
	@PostMapping(value = "rest", produces = "application/json;charset=utf-8")
	public String post() {
		return "post 데이터 저장 용도로 사용한다";
	}
	
	@PutMapping(value = "rest", produces = "application/json;charset=utf-8")
	public String put() {
		return "put 데이터 수정 용도로 사용한다";
	}
	
	@DeleteMapping(value = "rest", produces = "application/json;charset=utf-8")
	public String delete() {
		return "delete 데이터 삭제 용도로 사용한다";
	}
	
	static int cnt = 0;
	static HashMap<String, InfoDTO> hashDatabase = new HashMap<>();
	
	@GetMapping(value = "users", produces = "application/json;charset=utf-8")
	public ArrayList<InfoDTO> getUsers() {
		ArrayList<InfoDTO> list = new ArrayList<>();
		for (int i=cnt; i<cnt+10 ; i++) {
			InfoDTO info = new InfoDTO();
			info.setName("홍길동" +i);
			info.setAge(10+i);
			list.add(info);
			hashDatabase.put("홍길동" + i, info);
		}
		cnt += 10;
		return list;
	}
	
	@GetMapping(value="user1", produces="application/json;charset=utf-8")
	public InfoDTO user1 (@RequestParam String name) {
		return hashDatabase.get(name);
	}
	
	@GetMapping(value="user2/{aaa}", produces="application/json;charset=utf-8")
	public InfoDTO user2 (@PathVariable("aaa") String name) {
		System.out.println(hashDatabase.get(name) + "이름이다");
		return hashDatabase.get(name);
	}
	
	@PutMapping(value = "modify", produces = "application/json;charset=utf-8")
	public void modify(@RequestBody InfoDTO dto) {
		hashDatabase.replace(dto.getName(), dto);
	}
	
	
}
