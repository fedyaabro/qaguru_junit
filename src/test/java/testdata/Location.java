package testdata;

public enum Location {
  SPb("/sankt-peterburg/", "Санкт-Петербург"),
  MSK("/moskva_i_moskovskaya_oblast/", "Москва и МО"),
  EKB("/ekaterinburg/", "Екатеринбург");
  
  
  public final String path;
  public final String cityName;
  
  Location(String path, String cityName) {
    this.path = path;
    this.cityName = cityName;
  }
  

  
}

