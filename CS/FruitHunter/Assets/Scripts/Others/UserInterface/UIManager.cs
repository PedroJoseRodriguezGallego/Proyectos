using UnityEngine;
using UnityEngine.UI;
using UnityEngine.SceneManagement;


public class UIManager : MonoBehaviour
{
    public GameObject optionsPanel;
    public GameObject counters;
    public AudioSource clickSound;
    public GameObject soundIcon;
    public GameObject gameController;
    bool soundActive = true;


    public void showPanel()
    {
        gameController.GetComponent<GameController>().pauseMusic();
        clickSound.Play();
        Time.timeScale = 0;
        counters.SetActive(false);
        optionsPanel.SetActive(true);
    }


    public void menuOption()
    {
        clickSound.Play();
        Time.timeScale = 1f;
        SceneManager.LoadScene("Lobby");
    }


    public void retryLevel()
    {
        clickSound.Play();
        Time.timeScale = 1f;
        SceneManager.LoadScene(SceneManager.GetActiveScene().name);
    }

    
    public void returnOption()
    {
        clickSound.Play();
        gameController.GetComponent<GameController>().reanudeMusic();
        Time.timeScale = 1f;
        counters.SetActive(true);
        optionsPanel.SetActive(false);
    }


    public void exitOption()
    {
        clickSound.Play();
        Application.Quit();
    }


    public void changeMusic()
    {
        if(soundActive)
        {
            gameController.GetComponent<GameController>().muteMusic();
            soundActive = false;
            soundIcon.GetComponent<Image>().color = Color.red;
        }
            else if(!soundActive)
            {
                gameController.GetComponent<GameController>().unmuteMusic();
                soundActive = true;
                soundIcon.GetComponent<Image>().color = Color.green;
            }
    }

}