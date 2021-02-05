using UnityEngine;

public class PlantController : MonoBehaviour
{
    float waitedTime = 2f;
    float timeToAttack = 3f;
    public Animator animator;
    public GameObject bullet;
    public Transform spawnPoint;
    public SpriteRenderer spriteRenderer;
    public AudioSource pop;
    public bool toLeft;


    void Start() 
    {
        if(!toLeft)
        {
            spriteRenderer.flipX = true;
            BulletController.toLeft = false;
        }
            else
            {
                spriteRenderer.flipX = false;
                BulletController.toLeft = true;
            }
    }


    void Update()
    {
        if(waitedTime <= 0)
        {
            animator.Play("Attack");
            Invoke("ShotBullet",0.5f);
            waitedTime = timeToAttack;
        }
            else
            {
                waitedTime -= Time.deltaTime;
            }
    }


    void ShotBullet()
    {
        pop.Play();
        GameObject newBullet;
        newBullet = Instantiate(bullet,spawnPoint.position,spawnPoint.rotation);
    }
    
}