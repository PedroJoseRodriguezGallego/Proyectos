using UnityEngine;
using UnityEngine.SceneManagement;

public class GameController : MonoBehaviour
{
    public GameObject canvas;
    public AudioSource levelTheme;
    public AudioSource lobbyTheme;
    AudioSource music;


    void Start()
    {
        Time.timeScale = 1f;

        if(SceneManager.GetActiveScene().name == "Menu" || SceneManager.GetActiveScene().name == "Lobby")
        {
            music = lobbyTheme;
        }
            else
            {
                music = levelTheme;
            }

        Invoke("showCanvas",0.75f);
        music.Play();
    }


    void showCanvas()
    {
        canvas.SetActive(true);
    }


    public void pauseMusic()
    {
        music.Pause();
    }


    public void reanudeMusic()
    {
        music.UnPause();
    }


    public void muteMusic()
    {
        music.volume = 0;
    }


    public void unmuteMusic()
    {
        music.volume = 0.3f;
    }
}