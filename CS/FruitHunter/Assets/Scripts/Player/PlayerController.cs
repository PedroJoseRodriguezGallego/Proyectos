using UnityEngine;

public class PlayerController : MonoBehaviour
{
    #region variables
    float speed = 2f;
    float jumpSpeed = 3.5f;
    bool canDoubleJump;
    float doubleJumpSpeed = 3f;

    float dashSpeed = 5f;
    float dashTime =0.1f;
    float startDashTime = 0.1f;
    int direction;
    
    public Rigidbody2D rb2D;
    public SpriteRenderer spriteRenderer;
    public Animator animator;
    public AudioSource jumpSound;
    #endregion



    void Update()
    {
        #region movement
        if (Input.GetKey("d"))
        {
            rb2D.velocity = new Vector2(speed, rb2D.velocity.y);
            spriteRenderer.flipX = false;
            animator.SetBool("Running", true);
            animator.SetBool("Falling", false);
        }

            else if (Input.GetKey("a"))
            {
                rb2D.velocity = new Vector2(-speed, rb2D.velocity.y);
                spriteRenderer.flipX = true;
                animator.SetBool("Running", true);
                animator.SetBool("Falling", false);
            }

                else
                {
                    rb2D.velocity = new Vector2(0f, rb2D.velocity.y);
                    animator.SetBool("Running", false);
                }

        if (Input.GetKeyDown("w"))
        {
            if(CheckGround.isGrounded)
            {
                canDoubleJump = true;
                jumpSound.Play();
                rb2D.velocity = new Vector2(rb2D.velocity.x, jumpSpeed);
            }
                else if (canDoubleJump)
                {
                    animator.SetBool("DoubleJumping", true);
                    canDoubleJump = false;
                    jumpSound.Play();
                    rb2D.velocity = new Vector2(rb2D.velocity.x, doubleJumpSpeed);
                }
        }
        #endregion


        #region dash
        if(direction == 0)
        {
            if(Input.GetKeyDown(KeyCode.LeftShift))
            {
                if(rb2D.velocity.x < 0)
                {
                    direction = 1;
                }
                    else if(rb2D.velocity.x > 0)
                    {
                        direction = 2;
                    }
            }
        }
            else
            {
                if(dashTime <= 0)
                {
                    direction = 0;
                    dashTime = startDashTime;
                    rb2D.velocity = Vector2.zero;
                }
                    else
                    {
                        dashTime -= Time.deltaTime;

                        if(direction == 1)
                        {
                            rb2D.velocity = Vector2.left * dashSpeed;
                        }
                            else if(direction ==2)
                            {
                                rb2D.velocity = Vector2.right * dashSpeed;
                            }
                    }
            }
        #endregion

        #region animatorConditions
        if (!CheckGround.isGrounded)
        {
            animator.SetBool("Jumping", true);
            animator.SetBool("Running", false);
        }
            else
            {
                animator.SetBool("DoubleJumping", false);
                animator.SetBool("Jumping", false);
                animator.SetBool("Falling", false);
            }


        if (rb2D.velocity.y < 0 && !animator.GetBool("Running"))
        {
            animator.SetBool("Falling", true);
        }
            else
            {
                animator.SetBool("Falling", false);
            }
        #endregion
    }

}