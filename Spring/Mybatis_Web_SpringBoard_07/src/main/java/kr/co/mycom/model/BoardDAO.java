package kr.co.mycom.model;

import java.util.HashMap;
import java.util.List;

public interface BoardDAO {
	// board CRUD

	/*
	전체 조회 List<Board>
	조건 조회 Board > DTO
	삽입, 수정, 필요에 따라 ... 조건 검색, 조회수 증가
	*/
	// 메서드 정의
	// CRUD 기반
	int insertBoard(BoardDTO dto);
	int updateBoard(BoardDTO dto);
	int deleteBoard(BoardDTO dto); // int deleteBoard(String boardid)

	List<BoardDTO> getBoardList(HashMap map); // 전체 조회
	BoardDTO getBoard(int num); // 조건 조회

	void updateHit(int num); // 조회수 증가
	
	int getBoardCount(); // 전체 글 수

	void insertReply(BoardDTO dto); // 답변처리
	void updateSort(BoardDTO dto); // 답변 처리(step(sort) 값 변경)
	void createTable(BoardDTO dto);
	void insertUserDto(HashMap map);
}
