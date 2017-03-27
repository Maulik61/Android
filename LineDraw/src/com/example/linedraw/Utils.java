public class Utils {
	
	Context context;
	private Dialog progressDialog = null;
	private ProgressBar progressBar;

	public Utils(Context context) {

		this.context = context;
	}

	
      public void showPopupProgressSpinner(Boolean isShowing) {
		if (isShowing == true) {
			progressDialog = new Dialog(context);
			progressDialog.requestWindowFeature(Window.FEATURE_NO_TITLE);
			progressDialog.setContentView(R.layout.popup_progressbar);
			progressDialog.setCancelable(false);
			progressDialog.getWindow().setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));

			progressBar = (ProgressBar) progressDialog.findViewById(R.id.progressBar1);
			progressBar.getIndeterminateDrawable().setColorFilter(Color.parseColor("#ff6700"),
					android.graphics.PorterDuff.Mode.MULTIPLY);
			progressDialog.show();
		} else if (isShowing == false) {
			progressDialog.dismiss();
		}
	}
}
