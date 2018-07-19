import java.util.*;
public enum PromotionEnum
{
	FLAT10("FLAT10",new GregorianCalendar(2018,7,14),new GregorianCalendar(2018,7,29)),
	BUY500("BUY500",new GregorianCalendar(2018,7,7),new GregorianCalendar(2018,7,22));
	private String code;
	private GregorianCalendar startDate;
	private GregorianCalendar endDate;
	private PromotionEnum(String code, GregorianCalendar startDate, GregorianCalendar endDate)
	{
		this.code = code;
		this.startDate = startDate;
		this.endDate = endDate;
	}

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public GregorianCalendar getStartDate() {
		return startDate;
	}

	public void setStartDate(GregorianCalendar startDate) {
		this.startDate = startDate;
	}

	public GregorianCalendar getEndDate() {
		return endDate;
	}

	public void setEndDate(GregorianCalendar endDate) {
		this.endDate = endDate;
	}
	
}