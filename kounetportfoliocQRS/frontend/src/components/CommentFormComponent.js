import React from 'react'

const CommentFormComponent = () => {
  return (
    <section id="comment-form" className="comment-form section">
    <div className="container">

      <form action="">

        <h4>Post Comment</h4>
        <p>Your email address will not be published. Required fields are marked * </p>
        <div className="row">
          <div className="col-md-6 form-group">
            <input name="name" type="text" className="form-control" placeholder="Your Name*"/>
          </div>
          <div className="col-md-6 form-group">
            <input name="email" type="text" className="form-control" placeholder="Your Email*"/>
          </div>
        </div>
        <div className="row">
          <div className="col form-group">
            <input name="website" type="text" className="form-control" placeholder="Your Website"/>
          </div>
        </div>
        <div className="row">
          <div className="col form-group">
            <textarea name="comment" className="form-control" placeholder="Your Comment*"></textarea>
          </div>
        </div>

        <div className="text-center">
          <button type="submit" className="btn btn-primary">Post Comment</button>
        </div>

      </form>

    </div>
  </section>
  )
}

export default CommentFormComponent
