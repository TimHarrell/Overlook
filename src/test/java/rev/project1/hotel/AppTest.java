package rev.project1.hotel;

import java.sql.Connection;

import org.junit.Test;

import com.revature.beans.Inquiry;
import com.revature.dao.InquiryDao;
import com.revature.util.ConnectionUtil;

//import junit.framework.Test;
import junit.framework.TestCase;

public class AppTest extends TestCase {
	@Test
	public void testConnection() {
		try (Connection conn = ConnectionUtil.getConnection()) {
			
		} catch (Exception ex) {
			assertTrue(false); // if any exception is caught, test fails
		} 
		System.out.print("connected");
		assertTrue(true);
	}
	
	@Test
	public void testMakeAndRemove() {
		Inquiry inq = InquiryDao.makeInquiry("i", "i", "i");
		int id = InquiryDao.getInqByParts(1,  "i", "i");
		InquiryDao.setInqInvalidById(id);
		if(-1 == InquiryDao.getInqByParts(1,  "i", "i")) {
			assertTrue(true);
		}
		else {
			assertTrue(false);
		}
	}
	
	public void testmakeInq() {
		InquiryDao.makeInquiry("l", "l", "l");
		
	}
}
