package testdata;

import com.codeborne.selenide.*;

import java.util.List;

import static com.codeborne.selenide.CollectionCondition.texts;
import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$$;

public class YandexRealtyMainPageTestData {
  
  protected final SelenideElement citySelector = $("[data-test = 'RegionSelectorControl']");
  protected final SelenideElement filtersCategory = $("[data-test = 'Filters_category']");
  protected final SelenideElement categoryDropdown = $(".Select__popup_theme_realty");
  protected final SelenideElement filtersCtype = $("[data-test = 'Filters_ctype']");
  protected final ElementsCollection menuItems = $$(".Menu__item");
  
  
  public YandexRealtyMainPageTestData checkCity(String expectedCity) {
    citySelector.shouldHave(text(expectedCity));
    return this;
  }
  
  public YandexRealtyMainPageTestData clickOnTypeOfRealtyOnTheFilter() {
    filtersCategory.click();
    return this;
  }
  
  public YandexRealtyMainPageTestData categoryDropDownShouldBeVisible() {
    categoryDropdown.shouldBe(visible);
    return this;
  }
  
  
  public YandexRealtyMainPageTestData categoryDropDownShouldHaveText(String text) {
    categoryDropdown.shouldBe(visible);
    categoryDropdown.shouldHave(text(text));
    return this;
  }
  
  
  public YandexRealtyMainPageTestData categoryDropDownShouldNotHaveText(String text) {
    categoryDropdown.shouldBe(visible);
    categoryDropdown.shouldNotHave(text(text));
    return this;
  }
  
  public YandexRealtyMainPageTestData choseRentTab() {
    filtersCtype.parent().$(byText(DealTypes.LONG_RENT.description)).click();
    return this;
  }
  
  public YandexRealtyMainPageTestData choseSellTab() {
    filtersCtype.parent().$(byText(DealTypes.BUY.description)).click();
    return this;
  }
  
  public YandexRealtyMainPageTestData choseDailyTab() {
    filtersCtype.parent().$(byText(DealTypes.SHORT_RENT.description)).click();
    return this;
  }
  
  public YandexRealtyMainPageTestData choseFilterTab(String filterTab) {
    filtersCtype.parent().$(byText(filterTab)).click();
    return this;
  }
  
  public YandexRealtyMainPageTestData categoryDropDownShouldHaveExpectedText(List<String> expectedTexts) {
    categoryDropdown.shouldBe(visible);
    menuItems.shouldHave(texts(expectedTexts));
    return this;
  }
    
}
