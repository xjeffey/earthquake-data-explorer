package application;

import static org.junit.Assert.*;

import org.junit.Test;

public class EarthquakeTest {

	private final Earthquake.DepthSort depthSort = new Earthquake.DepthSort();
	private final Earthquake.StatusSort statusSort = new Earthquake.StatusSort();
	private final Earthquake.DateSort dateSort = new Earthquake.DateSort();
	private final Earthquake.PlaceSort placeSort = new Earthquake.PlaceSort();
	private final Earthquake.MagSort magSort = new Earthquake.MagSort();
	
	@Test
	public void setTimeTest() throws Exception {
		Earthquake quake = new Earthquake(null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null);
		quake.setTime("2019-02-05T17:48:00.460Z");
		assertEquals("Dates should match", "2019-02-05T17:48:00.460Z", quake.getTime());
	}

	@Test
	public void setLatitudeTest() {
		Earthquake quake = new Earthquake(null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null);
		quake.setLatitude("0");
		assertEquals("Latitude should match", "0", quake.getLatitude());
	}
	
	@Test
	public void setLongitudeTest() {
		Earthquake quake = new Earthquake(null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null);
		quake.setLongitude("0");
		assertEquals("Longitude should match", "0", quake.getLongitude());
	}
	
	@Test
	public void setDepthTest() {
		Earthquake quake = new Earthquake(null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null);
		quake.setDepth("0");
		assertEquals("Depths should match", "0", quake.getDepth());
	}
	
	@Test
	public void setMagTest() {
		Earthquake quake = new Earthquake(null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null);
		quake.setMag("0");
		assertEquals("Mag should match", "0", quake.getMag());
	}
	
	@Test
	public void setMagTypeTest() {
		Earthquake quake = new Earthquake(null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null);
		quake.setMagType("md");
		assertEquals("Mag Type should match", "md", quake.getMagType());
	}
	
	@Test
	public void setNstTest() {
		Earthquake quake = new Earthquake(null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null);
		quake.setNst("20");
		assertEquals("Nst should match", "20", quake.getNst());
	}

	@Test
	public void setGapTest() {
		Earthquake quake = new Earthquake(null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null);
		quake.setGap("90");
		assertEquals("Gap should match", "90", quake.getGap());
	}
	
	@Test
	public void setDminTest() {
		Earthquake quake = new Earthquake(null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null);
		quake.setDmin("20");
		assertEquals("Dmin should match", "20", quake.getDmin());
	}
	
	@Test
	public void setRmsTest() {
		Earthquake quake = new Earthquake(null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null);
		quake.setRms("20");
		assertEquals("Rms should match", "20", quake.getRms());
	}
	
	@Test
	public void setNetTest() {
		Earthquake quake = new Earthquake(null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null);
		quake.setNet("ci");
		assertEquals("Net should match", "ci", quake.getNet());
	}
	
	@Test
	public void setIdTest() {
		Earthquake quake = new Earthquake(null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null);
		quake.setId("20");
		assertEquals("Id should match", "20", quake.getID());
	}
	
	@Test
	public void setUpdatedTest() {
		Earthquake quake = new Earthquake(null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null);
		quake.setUpdated("2019-02-04");
		assertEquals("Updated should match", "2019-02-04", quake.getUpdated());
	}
	
	@Test
	public void setPlaceTest() {
		Earthquake quake = new Earthquake(null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null);
		quake.setPlace("Ohio");
		assertEquals("Place should match", "Ohio", quake.getPlace());
	}
	
	@Test
	public void setTypeTest() {
		Earthquake quake = new Earthquake(null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null);
		quake.setType("md");
		assertEquals("Type should match", "md", quake.getType());
	}
	
	@Test
	public void setHorizontalErrorTest() {
		Earthquake quake = new Earthquake(null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null);
		quake.setHorizontalError("20");
		assertEquals("Horizontal Error should match", "20", quake.getHorizontalError());
	}
	
	@Test
	public void setDepthErrorTest() {
		Earthquake quake = new Earthquake(null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null);
		quake.setDepthError("20");
		assertEquals("Depth Error should match", "20", quake.getDepthError());
	}
	
	@Test
	public void setMagErrorTest() {
		Earthquake quake = new Earthquake(null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null);
		quake.setMagError("20");
		assertEquals("Mag Error should match", "20", quake.getMagError());
	}
	
	@Test
	public void setMagNstTest() {
		Earthquake quake = new Earthquake(null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null);
		quake.setMagNst("20");
		assertEquals("Mag Nst should match", "20", quake.getMagNst());
	}
	
	@Test
	public void setStatusTest() {
		Earthquake quake = new Earthquake(null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null);
		quake.setStatus("automatic");
		assertEquals("Status should match", "automatic", quake.getStatus());
	}
	
	@Test
	public void setLocationSourceTest() {
		Earthquake quake = new Earthquake(null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null);
		quake.setLocationSource("ci");
		assertEquals("Location Source should match", "ci", quake.getLocationSource());
	}
	
	@Test
	public void setMagSourceTest() {
		Earthquake quake = new Earthquake(null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null);
		quake.setMagSource("ci");
		assertEquals("Mag Soucre should match", "ci", quake.getMagSource());
	}
	
	@Test
	public void depthSortLessTest() {
		Earthquake e1 = new Earthquake(null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null);
		Earthquake e2 = new Earthquake(null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null);
		
		e1.setDepth("5");
		e2.setDepth("10");
		
		int result = depthSort.compare(e1, e2);
		assertTrue("Expected to be true", result <= -1);
	}
	
	@Test
	public void depthSortGreaterTest() {
		Earthquake e1 = new Earthquake(null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null);
		Earthquake e2 = new Earthquake(null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null);
		
		e1.setDepth("5");
		e2.setDepth("10");
		
		int result = depthSort.compare(e2, e1);
		assertTrue("Expected to be true", result >= 1);
	}
	
	@Test
	public void depthSortEqualTest() {
		Earthquake e1 = new Earthquake(null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null);
		Earthquake e2 = new Earthquake(null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null);
		
		e1.setDepth("10");
		e2.setDepth("10");
		
		int result = depthSort.compare(e2, e1);
		assertTrue("Expected to be true", result == 0);
	}
	
	@Test
	public void magSortLessTest() {
		Earthquake e1 = new Earthquake(null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null);
		Earthquake e2 = new Earthquake(null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null);
		
		e1.setMag("5");
		e2.setMag("10");
		
		int result = magSort.compare(e1, e2);
		assertTrue("Expected to be true", result <= -1);
	}
	
	@Test
	public void magSortGreaterTest() {
		Earthquake e1 = new Earthquake(null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null);
		Earthquake e2 = new Earthquake(null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null);
		
		e1.setMag("5");
		e2.setMag("10");
		
		int result = magSort.compare(e2, e1);
		assertTrue("Expected to be true", result >= 1);
	}
	
	@Test
	public void magSortEqualTest() {
		Earthquake e1 = new Earthquake(null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null);
		Earthquake e2 = new Earthquake(null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null);
		
		e1.setMag("10");
		e2.setMag("10");
		
		int result = magSort.compare(e2, e1);
		assertTrue("Expected to be true", result == 0);
	}
	
	@Test
	public void placeSortLessTest() {
		Earthquake e1 = new Earthquake(null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null);
		Earthquake e2 = new Earthquake(null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null);
		
		e1.setPlace("11, CA");
		e2.setPlace("11, DA");
		
		int result = placeSort.compare(e1, e2);
		assertTrue("Expected to be true", result <= -1);
	}
	
	@Test
	public void placeSortGreaterTest() {
		Earthquake e1 = new Earthquake(null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null);
		Earthquake e2 = new Earthquake(null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null);
		
		e1.setPlace("11, BA");
		e2.setPlace("11, CA");
		
		int result = placeSort.compare(e2, e1);
		assertTrue("Expected to be true", result >= 1);
	}
	
	@Test
	public void placeSortEqualTest() {
		Earthquake e1 = new Earthquake(null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null);
		Earthquake e2 = new Earthquake(null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null);
		
		e1.setPlace("11, CA");
		e2.setPlace("11, CA");
		
		int result = placeSort.compare(e1, e2);
	
		assertTrue("Expected to be true", result == 0);
	}
	
	@Test
	public void statusSortLessTest() {
		Earthquake e1 = new Earthquake(null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null);
		Earthquake e2 = new Earthquake(null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null);
		
		e1.setStatus("automatic");
		e2.setStatus("bautomatic");
		
		int result = statusSort.compare(e1, e2);
		assertTrue("Expected to be true", result <= -1);
	}
	
	@Test
	public void statusSortGreaterTest() {
		Earthquake e1 = new Earthquake(null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null);
		Earthquake e2 = new Earthquake(null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null);
		
		e1.setStatus("bautomatic");
		e2.setStatus("cautomatic");
		
		int result = statusSort.compare(e2, e1);
		assertTrue("Expected to be true", result >= 1);
	}
	
	@Test
	public void statusSortEqualTest() {
		Earthquake e1 = new Earthquake(null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null);
		Earthquake e2 = new Earthquake(null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null);
		
		e1.setStatus("automatic");
		e2.setStatus("automatic");
		
		int result = statusSort.compare(e1, e2);
	
		assertTrue("Expected to be true", result == 0);
	}
	
	@Test
	public void dateSortLessTest() throws Exception {
		Earthquake e1 = new Earthquake(null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null);
		Earthquake e2 = new Earthquake(null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null);
			
		e1.setTime("2019-02-10 12:00:00");
		e2.setTime("2019-02-11 12:00:00");
		
		int result = dateSort.compare(e1, e2);
		assertTrue("Expected to be true", result <= -1);
	}
	
	@Test
	public void dateSortGreaterTest() throws Exception {
		Earthquake e1 = new Earthquake(null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null);
		Earthquake e2 = new Earthquake(null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null);
		
		e1.setTime("2019-02-11 12:00:00");
		e2.setTime("2019-02-12 12:00:00");
		
		int result = dateSort.compare(e2, e1);
		assertTrue("Expected to be true", result >= 1);
	}
	
	@Test
	public void dateSortEqualTest() throws Exception {
		Earthquake e1 = new Earthquake(null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null);
		Earthquake e2 = new Earthquake(null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null);
		
		e1.setTime("2019-02-11 12:00:00");
		e2.setTime("2019-02-11 12:00:00");
		
		int result = dateSort.compare(e1, e2);
	
		assertTrue("Expected to be true", result == 0);
	}
	
}
