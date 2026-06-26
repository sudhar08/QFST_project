import { test, expect } from '@playwright/test';

test("verify login", async ({ page }) => {
    await page.goto('/inventory.html');
    console.log(await page.url());
    await expect(page.getByText('Products')).toBeVisible();
});

test("verify logout ", async ({ page}) =>{
    await page.goto('/inventory.html');
    console.log(await page.url());
    await page.locator(".bm-burger-button").click();
    await page.getByText("Logout").click();

    await expect(page).toHaveTitle("Swag Labs");


})
