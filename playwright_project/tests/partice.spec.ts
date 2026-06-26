// import {test,expect ,Browser, Page} from '@playwright/test'
// import { firefox  } from '@playwright/test'

// test("login page practice" ,async() =>{
//     const browser:Browser =  await firefox.launch( {headless: false});
//     const page:Page = await browser.newPage();

//     await page.goto("https://training-support.net/webelements/login-form/");
//     await expect(page).toHaveTitle("Selenium: Login Form");
//     await page.locator("#username").fill("admin");
//     await page.locator("#password").fill("password");

//     // click the button

//     await page.getByText("Submit").click();

//     // check the value of the success page

//     // const successpagetext = await page.locator(".text-center font-display text-6xl font-bold text-emerald-500").textContent();
//     // console.log(successpagetext);



// });
