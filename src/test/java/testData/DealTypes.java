package testData;

public enum DealTypes {
  BUY("Купить"),
  LONG_RENT("Снять"),
  SHORT_RENT("Посуточно");
  
  public final String description;
  
  DealTypes(String description) {
    this.description = description;
  }
}
