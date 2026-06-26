import {test,expect} from '@playwright/test';

test("Get the 4 the item in the product page" , async ({ page}) =>{

    await page.goto("/inventory.html");
    const productname =   page.locator(".inventory_item_name");
    
    console.log(productname);
    const productprize =   await page.locator("inventory_item_price").textContent();
    const productimage =   await page.locator("inventory_item_img").textContent();


});

