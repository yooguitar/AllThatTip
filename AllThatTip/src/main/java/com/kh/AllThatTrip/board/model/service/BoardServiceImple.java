package com.kh.AllThatTrip.board.model.service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.kh.AllThatTrip.board.model.dao.BoardMapper;
import com.kh.AllThatTrip.board.model.vo.Board;
import com.kh.AllThatTrip.common.model.template.Pagination;
import com.kh.AllThatTrip.common.model.vo.PageInfo;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Service
@RequiredArgsConstructor
@Slf4j
public class BoardServiceImple implements BoardService {
	
	@Autowired
	private BoardMapper mapper;
	

    @Override
    public Map<String, Object> selectBoardList(int currentPage) {
        int totalCount = getTotalCount();

        PageInfo pageInfo = Pagination.getPageInfo(totalCount, currentPage, 5, 5);

        List<Board> boards = mapper.selectBoardList(pageInfo); 
        log.info("게시글 목록: {}", boards);

        Map<String, Object> resultMap = new HashMap<>();
        resultMap.put("boards", boards);
        resultMap.put("pageInfo", pageInfo);

        return resultMap;
    }

    private int getTotalCount() {
        return mapper.selectTotalCount(); 
    }
	
		
		
	

	@Override
	public void insertBoard(Board board, MultipartFile upfile) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public Map<String, Object> selectById(long boardNo) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void updateBoard(Board boardNo, MultipartFile upfile) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void deleteBoard(Board boardNo, String changeName) {
		// TODO Auto-generated method stub
		
	}
	
}
