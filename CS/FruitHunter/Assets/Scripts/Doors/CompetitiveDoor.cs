using UnityEngine;
using UnityEngine.SceneManagement;
using UnityEngine.UI;

public class CompetitiveDoor : MonoBehaviour
{
    public Text timer;
    public Animator transitionAnimator;
    public GameObject canvas;

    bool inDoor;
    float time = 3.25f;


    void Update()
    {
        if(inDoor)
        {
            time -= Time.deltaTime;
            timer.text = time.ToString("F0");
        }
        
        if(inDoor && time <= 0)
        {
            transitionAnimator.SetBool("Changing", true);
            canvas.SetActive(false);
            Invoke("loadCompetitive",1f);
        }
    }


    void loadCompetitive()
    {
        SceneManager.LoadScene("Competitive");
    }


    private void OnTriggerEnter2D(Collider2D collision)
    {
        if(collision.transform.CompareTag("Player"))
        {
            inDoor = true;
            timer.gameObject.SetActive(true);
        }
    }


    private void OnTriggerExit2D(Collider2D collision)
    {
        inDoor = false;
        timer.gameObject.SetActive(false);
        time = 3.25f;
    }

}