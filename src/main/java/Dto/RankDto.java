package Dto;

public class RankDto {
	private String m_no;
	private String m_name;
	private String sum_count;
	
	
	//defalut 생성자
	public RankDto() {
		// TODO Auto-generated constructor stub
	}
	//getter and setter


	public String getM_no() {
		return m_no;
	}


	public void setM_no(String m_no) {
		this.m_no = m_no;
	}


	public String getM_name() {
		return m_name;
	}


	public void setM_name(String m_name) {
		this.m_name = m_name;
	}


	public String getSum_count() {
		return sum_count;
	}


	public void setSum_count(String sum_count) {
		this.sum_count = sum_count;
	}


	
	
	//toString
	
	@Override
	public String toString() {
		return "RankDto [m_no=" + m_no + ", m_name=" + m_name + ", sum_count=" + sum_count + "]";
	}
	
	
}
