using UnityEngine;
using UnityEngine.UI;


public class PlayerRespawn : MonoBehaviour
{
    public int vidas = 3;
    bool reachedSpawn;
    bool retried;

    float spawnX;
    float spawnY;
    float spawnZ;

    public Rigidbody2D rb2D;
    public Animator animator;
    public GameObject deathPanel;
    public GameObject indicators;
    public GameObject settingsButton;
    public GameObject gameController;
    public AudioSource hitSound;
    public AudioSource deadSound;
    public Text lifeCounter;



    public void reachSpawn(float x, float y, float z)
    {
        reachedSpawn = true;

        spawnX = x;
        spawnY = y;
        spawnZ = z;
    }


    public void getHitted()
    {
        vidas --;
        lifeCounter.text = vidas.ToString();
        hitSound.Play();
        rb2D.velocity = new Vector2(rb2D.velocity.x,2f);
        animator.Play("Hit");
        
        if(vidas == 0)
        {
            if(reachedSpawn && !retried)
            {
                vidas = vidas + 3;
                lifeCounter.text = vidas.ToString();
                gameObject.transform.position = new Vector3(spawnX,spawnY,spawnZ);
                retried = true;
            }
                else
                {
                    gameController.GetComponent<GameController>().pauseMusic();
                    deadSound.Play();
                    Time.timeScale = 0f;
                    deathPanel.SetActive(true);
                    indicators.SetActive(false);
                    settingsButton.SetActive(false);
                }
        }
    }

}