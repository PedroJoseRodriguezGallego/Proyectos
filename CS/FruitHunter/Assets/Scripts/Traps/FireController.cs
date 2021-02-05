using UnityEngine;

public class FireController : MonoBehaviour
{
    public GameObject player;
    public Animator animator;
    public bool canHit;
    float timer = 0.4f;
    

    void Update()
    {
        if(canHit)
        {
            if(timer <= 0f)
            {
                player.transform.GetComponent<PlayerRespawn>().getHitted();
                timer = 0.4f;
            }
                else
                {
                    timer -= Time.deltaTime;
                }
        }
            else
            {
                timer = 0.4f;
            }
    }

}