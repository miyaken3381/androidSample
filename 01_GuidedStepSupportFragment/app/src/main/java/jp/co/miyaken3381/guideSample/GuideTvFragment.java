package jp.co.miyaken3381.guideSample;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.util.Log;

import androidx.annotation.NonNull;
import androidx.leanback.app.GuidedStepSupportFragment;
import androidx.leanback.widget.GuidanceStylist;
import androidx.leanback.widget.GuidedAction;

import java.util.List;

public class GuideTvFragment extends GuidedStepSupportFragment {
    public final long ACTION_CASE1 = 1000;
    public final long ACTION_CASE2 = 2000;
    public final long ACTION_CASE3 = 3000;
    private GuideTvFragmentListener mListener;
    private String mTitle;
    private String mMessage;

    public GuideTvFragment(String title, String message) {
        mTitle = title;
        mMessage = message;
    }

    @Override
    public void onAttach(@NonNull Context context) {
        super.onAttach(context);
        // contextクラスがMyListenerを実装しているかをチェック
        if (context instanceof GuideTvFragmentListener) {
            mListener = (GuideTvFragmentListener) context;
        }
    }

    @Override
    public void onDetach() {
        mListener = null;   // Fragmentを離れた後の再実行防止
        super.onDetach();
    }

    @Override
    public GuidanceStylist.Guidance onCreateGuidance(Bundle savedInstanceState) {
        String breadcrumb = "Guideサンプル";
        String title = mTitle;
        String description = mMessage;
        Drawable icon = getActivity().getDrawable(R.drawable.ic_info);
        return new GuidanceStylist.Guidance(title, description, breadcrumb, icon);
    }

    @Override
    public void onCreateActions(@NonNull List<GuidedAction> actions, Bundle savedInstanceState) {
        super.onCreateActions(actions, savedInstanceState);
        actions.add(new GuidedAction.Builder()
                .id(ACTION_CASE1)
                .title("ボタン１")
                .description("ボタン説明１")
                .hasNext(false)
                .build());
        actions.add(new GuidedAction.Builder()
                .id(ACTION_CASE2)
                .title("ボタン２")
                .description("ボタン説明２")
                .hasNext(false)
                .build());
        actions.add(new GuidedAction.Builder()
                .id(ACTION_CASE3)
                .title("ボタン３")
                .description("ボタン説明３")
                .hasNext(false)
                .build());
    }

    @Override
    public void onGuidedActionClicked(GuidedAction action) {
        if (mListener != null) {
            mListener.onClickButton(action.getId());
        }
        // Fragment終了
        getParentFragmentManager().beginTransaction().remove(this).commit();
    }
}
