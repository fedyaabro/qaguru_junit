package pages;

import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.*;
import testdata.DealTypes;
import testdata.Location;
import testdata.YandexRealtyMainPageTestData;

import java.util.List;
import java.util.stream.Stream;

import static com.codeborne.selenide.Selenide.open;

public class YandexRealtyMainPageSmokeTests extends TestBase {
  
  YandexRealtyMainPageTestData mainPage = new YandexRealtyMainPageTestData();
  
  
  static Stream<Arguments> dropDownShouldHaveRealtyTypesDependingOnDealTubs(){
    
    return Stream.of(
      Arguments.of(DealTypes.BUY, List.of("Квартиру", "Комнату", "Дом", "Участок", "Гараж или машиноместо", "Коммерческую недвижимость")),
      Arguments.of(DealTypes.LONG_RENT,List.of("Квартиру", "Комнату", "Дом", "Гараж или машиноместо", "Коммерческую недвижимость")),
      Arguments.of(DealTypes.SHORT_RENT, List.of("Квартиру", "Комнату", "Дом")));
  }
  
  @MethodSource
  @ParameterizedTest(name = "На табе {0} в дропдауне есть {1}")
  @Tag("smoke")
  void dropDownShouldHaveRealtyTypesDependingOnDealTubs(DealTypes dealTubs, List<String> expectedRealtyTypes){
    open(Location.SPb.path);
    mainPage
      .choseFilterTab(dealTubs.description)
      .clickOnTypeOfRealtyOnTheFilter()
      .categoryDropDownShouldHaveExpectedText(expectedRealtyTypes);
  }
  
  @CsvSource(value = {
    "/sankt-peterburg/ ,  Санкт-Петербург",
    "/moskva_i_moskovskaya_oblast/ , Москва и МО",
    "/amurskaya_oblast/ , Амурская область"
  })
  @ParameterizedTest
  @Tag("Smoke")
  @DisplayName("Город на главной должен соответствовать локации в адресной строке")
  @Disabled
  void locationOnManePageShouldBeEqualLocationFromSitePath(String locationPath, String expectedCity) {
    open(locationPath);
    mainPage.checkCity(expectedCity);
  }
  
  
  @EnumSource(Location.class)
  @ParameterizedTest
  @Tag("Smoke")
  @DisplayName("Город на главной должен соответствовать локации в адресной строке")
  void locationOnManePageShouldBeEqualLocationFromSitePathWithEnum(Location location) {
    open(location.path);
    mainPage.checkCity(location.cityName);
  }
  
  @Test
  @Disabled
  @Tag("Smoke")
  @DisplayName("При клике на тип недвижимости в фильтре открылся дропдаун")
  void afterClickOnRealtyTypeDropDownShouldBeOpen(){
   open(Location.SPb.path);
   mainPage
     .clickOnTypeOfRealtyOnTheFilter()
     .categoryDropDownShouldBeVisible();
  }
  
  @ValueSource(strings = {
    "Квартиру",
    "Комнату",
    "Дом",
    "Участок",
    "Гараж или машиноместо",
    "Коммерческую недвижимость"
  })
  
  @ParameterizedTest(name = "В дропдауне есть {0}")
  @DisplayName("В дропдауне  есть возможность выбрать определенный тип недвижимости")
  void sellingDropDownShouldHaveRealtyTypes(String realtyTypes){
    open(Location.SPb.path);
    mainPage
      .choseSellTab()
      .clickOnTypeOfRealtyOnTheFilter()
      .categoryDropDownShouldBeVisible()
      .categoryDropDownShouldHaveText(realtyTypes);
  }
  
}
