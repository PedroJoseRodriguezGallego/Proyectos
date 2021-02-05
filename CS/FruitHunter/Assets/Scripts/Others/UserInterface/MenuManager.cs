using UnityEngine;
using UnityEngine.SceneManagement;

public class MenuManager : MonoBehaviour
{
    public AudioSource clickSound;
    public GameObject infoPanel;


    public void loadGame()
    {
        clickSound.Play();
        SceneManager.LoadScene("Lobby");
    }


    public void exitGame()
    {
        clickSound.Play();
        Application.Quit();
    }


    public void changePanel()
    {
        if(infoPanel.activeSelf)
        {
            infoPanel.SetActive(false);
        }
            else
            {
                infoPanel.SetActive(true);
            }
    }


    public void IGlink()
    {
        Application.OpenURL("https://www.instagram.com/prodriguezgallego/?hl=es");
    }


    public void TWlink()
    {
        Application.OpenURL("https://twitter.com/pedrito626");
    }
}