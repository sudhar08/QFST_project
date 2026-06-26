import { firefox ,type FullConfig } from "playwright/test";

async function globalSetup(config: FullConfig) {

    const {baseURL , storageState}  = config.projects[0].use;
    const browser  =await firefox.launch();
    const page = browser.newPage();

    (await page).goto(baseURL!);
     (await page).getByRole('textbox',{name : "Username"}).fill('standard_user');
     (await page).getByRole('textbox',{name : "Password"}).fill('secret_sauce');

     (await page).getByText('Login').click();

     (await page).context().storageState({path: storageState as string});

    
}

export default globalSetup;
