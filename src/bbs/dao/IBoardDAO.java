package bbs.dao;

import java.util.List;

import bbs.entity.Board;

public interface IBoardDAO {

	public Board findBoardById(int boardId); // ����id���Ұ��

	public List<Board> findBoardList(); // ��ѯ����б�

}
