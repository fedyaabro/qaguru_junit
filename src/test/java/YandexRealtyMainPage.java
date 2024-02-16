import com.codeborne.selenide.*;
import testData.DealTypes;

import java.util.List;

import static com.codeborne.selenide.CollectionCondition.texts;
import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$$;

public class YandexRealtyMainPage {
  
  protected final SelenideElement citySelector = $("[data-test = 'RegionSelectorControl']");
  protected final SelenideElement filtersCategory = $("[data-test = 'Filters_category']");
  protected final SelenideElement categoryDropdown = $(".Select__popup_theme_realty");
  protected final SelenideElement filtersCtype = $("[data-test = 'Filters_ctype']");
  protected final ElementsCollection menuItems = $$(".Menu__item");
  
  
  void checkCity(String expectedCity) {
    citySelector.shouldHave(text(expectedCity));
  }
  
  public YandexRealtyMainPage clickOnTypeOfRealtyOnTheFilter() {
    filtersCategory.click();
    return this;
  }
  
  public YandexRealtyMainPage categoryDropDownShouldBeVisible() {
    categoryDropdown.shouldBe(visible);
    return this;
  }
  
  
  public YandexRealtyMainPage categoryDropDownShouldHaveText(String text) {
    categoryDropdown.shouldBe(visible);
    categoryDropdown.shouldHave(text(text));
    return this;
  }
  
  
  public YandexRealtyMainPage categoryDropDownShouldNotHaveText(String text) {
    categoryDropdown.shouldBe(visible);
    categoryDropdown.shouldNotHave(text(text));
    return this;
  }
  
  public YandexRealtyMainPage choseRentTab() {
    filtersCtype.parent().$(byText(DealTypes.LONG_RENT.description)).click();
    return this;
  }
  
  public YandexRealtyMainPage choseSellTab() {
    filtersCtype.parent().$(byText(DealTypes.BUY.description)).click();
    return this;
  }
  
  public YandexRealtyMainPage choseDailyTab() {
    filtersCtype.parent().$(byText(DealTypes.SHORT_RENT.description)).click();
    return this;
  }
  
  public YandexRealtyMainPage choseFilterTab(String filterTab) {
    filtersCtype.parent().$(byText(filterTab)).click();
    return this;
  }
  
  public YandexRealtyMainPage categoryDropDownShouldHaveExpectedText(List<String> expectedTexts) {
    categoryDropdown.shouldBe(visible);
    menuItems.shouldHave(texts(expectedTexts));
    return this;
  }
    
}
