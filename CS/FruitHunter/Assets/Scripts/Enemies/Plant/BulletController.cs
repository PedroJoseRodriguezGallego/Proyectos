using UnityEngine;

public class BulletController : MonoBehaviour
{
    float speed = 2.25f;
    public static bool toLeft;


    void Start() 
    {
        Destroy(gameObject,3f);
    }


    void Update() 
    {
        if(toLeft)
        {
            transform.Translate(Vector2.left * speed * Time.deltaTime);
        }
            else
            {
                transform.Translate(Vector2.right * speed * Time.deltaTime);
            }
    }


    void OnCollisionEnter2D(Collision2D other) 
    {
        Destroy(gameObject,0f);
    }

}