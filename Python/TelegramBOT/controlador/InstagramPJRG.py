from _csv import reader
from time import sleep
import subprocess
import shutil
import os
from selenium import webdriver
from selenium.webdriver.chrome.options import Options


def followAccount(usuario, contra, target):
    chromedriver_path = '../resources/chromedriver.exe'
    chrome_options = Options().add_experimental_option("detach", True)
    browser = webdriver.Chrome(options=chrome_options, executable_path=chromedriver_path)
    browser.implicitly_wait(5)

    browser.get('https://www.instagram.com/')

    sleep(5)

    cookiesButton = browser.find_element_by_xpath("/html/body/div[2]/div/div/div/div[2]/button[1]")
    cookiesButton.click()

    username_input = browser.find_element_by_css_selector("input[name='username']")
    password_input = browser.find_element_by_css_selector("input[name='password']")

    username_input.send_keys(usuario)
    password_input.send_keys(contra)

    login_button = browser.find_element_by_xpath("//button[@type='submit']")
    login_button.click()

    sleep(5)

    guardarInformacionSesion = browser.find_element_by_xpath('//*[@id="react-root"]/section/main/div/div/div/div/button')
    guardarInformacionSesion.click()

    sleep(5)

    activarNotificacionesButton = browser.find_element_by_xpath('/html/body/div[4]/div/div/div/div[3]/button[2]')
    activarNotificacionesButton.click()

    sleep(5)

    try:
        browser.get(f"https://www.instagram.com/{target}")
        try:
            followPublicButton = browser.find_element_by_xpath("/html/body/div[1]/section/main/div/header/section/div[1]/div[1]/div/div/div/span/span[1]/button")
            followPublicButton.click()
            sleep(5)
            browser.close()
        except:
            followPrivateButton = browser.find_element_by_xpath("/html/body/div[1]/section/main/div/header/section/div[1]/div[1]/div/div/button")
            followPrivateButton.click()
            sleep(5)
            browser.close()
    except:
        print(f"La cuenta {target} no existe")
        browser.close()


def scrapearImagenes(perfil):
    subprocess.run('instagram-scraper ' + perfil + ' -u botspjrg1 -p Admin1234_')
    archivo_zip = shutil.make_archive(perfil, "zip", perfil) #Solo lo envia si pesa menos de 50mb
    os.remove("instagram-scraper.log")
    return archivo_zip


def lanzarBots(target):
    with open('../resources/botInstagramInfo.csv', 'r') as read_obj:
        csv_reader = reader(read_obj)
        header = next(csv_reader)

        if header is not None:
            for row in csv_reader:
                followAccount(row[0], row[1], target)


def getBots():
    index = 0

    with open('../resources/botInstagramInfo.csv', 'r') as read_obj:
        csv_reader = reader(read_obj)
        header = next(csv_reader)

        if header is not None:
            for row in csv_reader:
                index = index + 1

    return index
