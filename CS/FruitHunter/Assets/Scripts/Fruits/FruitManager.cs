using UnityEngine;
using UnityEngine.UI;

public class FruitManager : MonoBehaviour
{
    public Animator transitionAnimator;
    public Text fruitCounter;
    public GameObject canvas;
    public Text timer;

    public GameObject winPanel;
    public GameObject gameController;
    public GameObject indicators;
    public GameObject settingsButton;

    float time;
    bool clock;
    int totalFruits;


    private void Start()
    {
        totalFruits = transform.childCount;
        Invoke("startClock",1f);
    }


    private void Update()
    {
        fruitCounter.text = transform.childCount + "/" + totalFruits;

        if(transform.childCount == 0)
        {
            Time.timeScale = 0f;
            gameController.GetComponent<GameController>().pauseMusic();
            winPanel.SetActive(true);
            indicators.SetActive(false);
            settingsButton.SetActive(false);
        }
            else
            {
                if(clock)
                {
                    time += Time.deltaTime;
                    timer.text = time.ToString("F2");
                }
            }
    }


    void startClock()
    {
        clock = true;
    }


    public float infoTime()
    {
        return time;
    }

}