using UnityEngine.SceneManagement;
using UnityEngine;

public class TrainingDoor : MonoBehaviour
{
    public GameObject panel;
    public Animator transitionAnimator;
    public GameObject canvas;
    public GameObject settingsButton;


    private void OnTriggerEnter2D(Collider2D collision)
    {
        if (collision.transform.CompareTag("Player"))
        {
            settingsButton.SetActive(false);
            panel.gameObject.SetActive(true);
        }
    }


    private void OnTriggerExit2D(Collider2D collision)
    {
        settingsButton.SetActive(true);
        panel.gameObject.SetActive(false);
    }


    #region levels
    public void loadLevel1()
    {
        panel.gameObject.SetActive(false);
        canvas.SetActive(false);
        transitionAnimator.SetBool("Changing", true);
        Invoke("level1",1f);
    }
    
    public void loadLevel2()
    {
        panel.gameObject.SetActive(false);
        canvas.SetActive(false);
        transitionAnimator.SetBool("Changing", true);
        Invoke("level2",1f);
    }

    public void loadLevel3()
    {
        panel.gameObject.SetActive(false);
        canvas.SetActive(false);
        transitionAnimator.SetBool("Changing", true);
        Invoke("level3",1f);
    }

    public void loadLevel4()
    {
        panel.gameObject.SetActive(false);
        canvas.SetActive(false);
        transitionAnimator.SetBool("Changing", true);
        Invoke("level4",1f);
    }



    void level1()
    {
        SceneManager.LoadScene("Nivel 1");
    }

    void level2()
    {
        SceneManager.LoadScene("Nivel 2");
    }

    void level3()
    {
        SceneManager.LoadScene("Nivel 3");
    }

    void level4()
    {
        SceneManager.LoadScene("Nivel 4");
    }
    #endregion

}