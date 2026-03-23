package androidx.compose.ui.viewinterop;

import android.graphics.Rect;
import android.view.FocusFinder;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewTreeObserver;
import androidx.compose.runtime.collection.MutableVector;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.focus.FocusDirection;
import androidx.compose.ui.focus.FocusInteropUtils_androidKt;
import androidx.compose.ui.focus.FocusOwner;
import androidx.compose.ui.focus.FocusProperties;
import androidx.compose.ui.focus.FocusPropertiesModifierNode;
import androidx.compose.ui.focus.FocusRequester;
import androidx.compose.ui.focus.FocusTargetNode;
import androidx.compose.ui.focus.FocusTransactionManager;
import androidx.compose.ui.focus.FocusTransactionsKt;
import androidx.compose.ui.internal.InlineClassHelperKt;
import androidx.compose.ui.node.DelegatableNode;
import androidx.compose.ui.node.DelegatableNodeKt;
import androidx.compose.ui.node.DelegatingNode;
import androidx.compose.ui.node.NodeKind;
import androidx.compose.ui.node.Owner;
import kotlin.Metadata;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.FunctionReferenceImpl;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: FocusGroupNode.android.kt */
@Metadata(d1 = {"\u0000B\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u000b\b\u0002\u0018\u00002\u00020\u00012\u00020\u00022\u00020\u00032\u00020\u0004B\u0005¢\u0006\u0002\u0010\u0005J\u0010\u0010\f\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\u000fH\u0016J\b\u0010\u0010\u001a\u00020\u0011H\u0002J\b\u0010\u0012\u001a\u00020\rH\u0016J\b\u0010\u0013\u001a\u00020\rH\u0016J\u0018\u0010\u0014\u001a\u00020\u00152\u0006\u0010\u0016\u001a\u00020\u0017ø\u0001\u0000¢\u0006\u0004\b\u0018\u0010\u0019J\u0018\u0010\u001a\u001a\u00020\u00152\u0006\u0010\u0016\u001a\u00020\u0017ø\u0001\u0000¢\u0006\u0004\b\u001b\u0010\u0019J\u001c\u0010\u001c\u001a\u00020\r2\b\u0010\u001d\u001a\u0004\u0018\u00010\u00072\b\u0010\u001e\u001a\u0004\u0018\u00010\u0007H\u0016J\u0010\u0010\u001f\u001a\u00020\r2\u0006\u0010 \u001a\u00020\u0007H\u0016J\u0010\u0010!\u001a\u00020\r2\u0006\u0010 \u001a\u00020\u0007H\u0016R\u001c\u0010\u0006\u001a\u0004\u0018\u00010\u0007X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\b\u0010\t\"\u0004\b\n\u0010\u000b\u0082\u0002\u0007\n\u0005\b¡\u001e0\u0001¨\u0006\""}, d2 = {"Landroidx/compose/ui/viewinterop/FocusGroupPropertiesNode;", "Landroidx/compose/ui/Modifier$Node;", "Landroidx/compose/ui/focus/FocusPropertiesModifierNode;", "Landroid/view/ViewTreeObserver$OnGlobalFocusChangeListener;", "Landroid/view/View$OnAttachStateChangeListener;", "()V", "focusedChild", "Landroid/view/View;", "getFocusedChild", "()Landroid/view/View;", "setFocusedChild", "(Landroid/view/View;)V", "applyFocusProperties", "", "focusProperties", "Landroidx/compose/ui/focus/FocusProperties;", "getFocusTargetOfEmbeddedViewWrapper", "Landroidx/compose/ui/focus/FocusTargetNode;", "onAttach", "onDetach", "onEnter", "Landroidx/compose/ui/focus/FocusRequester;", "focusDirection", "Landroidx/compose/ui/focus/FocusDirection;", "onEnter-3ESFkO8", "(I)Landroidx/compose/ui/focus/FocusRequester;", "onExit", "onExit-3ESFkO8", "onGlobalFocusChanged", "oldFocus", "newFocus", "onViewAttachedToWindow", "v", "onViewDetachedFromWindow", "ui_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
/* loaded from: classes.dex */
final class FocusGroupPropertiesNode extends Modifier.Node implements FocusPropertiesModifierNode, ViewTreeObserver.OnGlobalFocusChangeListener, View.OnAttachStateChangeListener {
    private View focusedChild;

    public final View getFocusedChild() {
        return this.focusedChild;
    }

    public final void setFocusedChild(View view) {
        this.focusedChild = view;
    }

    @Override // androidx.compose.ui.focus.FocusPropertiesModifierNode
    public void applyFocusProperties(FocusProperties focusProperties) {
        focusProperties.setCanFocus(false);
        focusProperties.setEnter(new AnonymousClass1(this));
        focusProperties.setExit(new AnonymousClass2(this));
    }

    /* compiled from: FocusGroupNode.android.kt */
    @Metadata(k = 3, mv = {1, 8, 0}, xi = 48)
    /* renamed from: androidx.compose.ui.viewinterop.FocusGroupPropertiesNode$applyFocusProperties$1, reason: invalid class name */
    /* synthetic */ class AnonymousClass1 extends FunctionReferenceImpl implements Function1<FocusDirection, FocusRequester> {
        AnonymousClass1(Object obj) {
            super(1, obj, FocusGroupPropertiesNode.class, "onEnter", "onEnter-3ESFkO8(I)Landroidx/compose/ui/focus/FocusRequester;", 0);
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ FocusRequester invoke(FocusDirection focusDirection) {
            return m6949invoke3ESFkO8(focusDirection.getValue());
        }

        /* renamed from: invoke-3ESFkO8, reason: not valid java name */
        public final FocusRequester m6949invoke3ESFkO8(int p0) {
            return ((FocusGroupPropertiesNode) this.receiver).m6947onEnter3ESFkO8(p0);
        }
    }

    /* compiled from: FocusGroupNode.android.kt */
    @Metadata(k = 3, mv = {1, 8, 0}, xi = 48)
    /* renamed from: androidx.compose.ui.viewinterop.FocusGroupPropertiesNode$applyFocusProperties$2, reason: invalid class name */
    /* synthetic */ class AnonymousClass2 extends FunctionReferenceImpl implements Function1<FocusDirection, FocusRequester> {
        AnonymousClass2(Object obj) {
            super(1, obj, FocusGroupPropertiesNode.class, "onExit", "onExit-3ESFkO8(I)Landroidx/compose/ui/focus/FocusRequester;", 0);
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ FocusRequester invoke(FocusDirection focusDirection) {
            return m6950invoke3ESFkO8(focusDirection.getValue());
        }

        /* renamed from: invoke-3ESFkO8, reason: not valid java name */
        public final FocusRequester m6950invoke3ESFkO8(int p0) {
            return ((FocusGroupPropertiesNode) this.receiver).m6948onExit3ESFkO8(p0);
        }
    }

    /* renamed from: onEnter-3ESFkO8, reason: not valid java name */
    public final FocusRequester m6947onEnter3ESFkO8(int focusDirection) {
        View embeddedView = FocusGroupNode_androidKt.getView(this);
        if (embeddedView.isFocused() || embeddedView.hasFocus()) {
            return FocusRequester.INSTANCE.getDefault();
        }
        FocusOwner focusOwner = DelegatableNodeKt.requireOwner(this).getFocusOwner();
        Object objRequireOwner = DelegatableNodeKt.requireOwner(this);
        Intrinsics.checkNotNull(objRequireOwner, "null cannot be cast to non-null type android.view.View");
        View hostView = (View) objRequireOwner;
        boolean targetViewFocused = FocusInteropUtils_androidKt.requestInteropFocus(embeddedView, FocusInteropUtils_androidKt.m3871toAndroidFocusDirection3ESFkO8(focusDirection), FocusGroupNode_androidKt.getCurrentlyFocusedRect(focusOwner, hostView, embeddedView));
        FocusRequester.Companion companion = FocusRequester.INSTANCE;
        return targetViewFocused ? companion.getDefault() : companion.getCancel();
    }

    /* renamed from: onExit-3ESFkO8, reason: not valid java name */
    public final FocusRequester m6948onExit3ESFkO8(int focusDirection) {
        View nextView;
        View embeddedView = FocusGroupNode_androidKt.getView(this);
        if (!embeddedView.hasFocus()) {
            return FocusRequester.INSTANCE.getDefault();
        }
        FocusOwner focusOwner = DelegatableNodeKt.requireOwner(this).getFocusOwner();
        Object objRequireOwner = DelegatableNodeKt.requireOwner(this);
        Intrinsics.checkNotNull(objRequireOwner, "null cannot be cast to non-null type android.view.View");
        View hostView = (View) objRequireOwner;
        if (embeddedView instanceof ViewGroup) {
            Rect focusedRect = FocusGroupNode_androidKt.getCurrentlyFocusedRect(focusOwner, hostView, embeddedView);
            Integer numM3871toAndroidFocusDirection3ESFkO8 = FocusInteropUtils_androidKt.m3871toAndroidFocusDirection3ESFkO8(focusDirection);
            int androidFocusDirection = numM3871toAndroidFocusDirection3ESFkO8 != null ? numM3871toAndroidFocusDirection3ESFkO8.intValue() : 130;
            FocusFinder $this$onExit_3ESFkO8_u24lambda_u241 = FocusFinder.getInstance();
            if (this.focusedChild != null) {
                nextView = $this$onExit_3ESFkO8_u24lambda_u241.findNextFocus((ViewGroup) hostView, this.focusedChild, androidFocusDirection);
            } else {
                nextView = $this$onExit_3ESFkO8_u24lambda_u241.findNextFocusFromRect((ViewGroup) hostView, focusedRect, androidFocusDirection);
            }
            if (nextView != null && FocusGroupNode_androidKt.containsDescendant(embeddedView, nextView)) {
                nextView.requestFocus(androidFocusDirection, focusedRect);
                return FocusRequester.INSTANCE.getCancel();
            }
            if (hostView.requestFocus()) {
                return FocusRequester.INSTANCE.getDefault();
            }
            throw new IllegalStateException("host view did not take focus".toString());
        }
        if (hostView.requestFocus()) {
            return FocusRequester.INSTANCE.getDefault();
        }
        throw new IllegalStateException("host view did not take focus".toString());
    }

    private final FocusTargetNode getFocusTargetOfEmbeddedViewWrapper() {
        DelegatableNode $this$visitLocalDescendants_u2d6rFNWt0$iv;
        int type$iv;
        int i;
        DelegatableNode $this$visitLocalDescendants_u2d6rFNWt0$iv2;
        int type$iv2;
        int i2;
        int count$iv$iv;
        MutableVector mutableVector;
        boolean foundFocusTargetOfFocusGroup = false;
        FocusGroupPropertiesNode $this$visitLocalDescendants_u2d6rFNWt0$iv3 = this;
        int type$iv3 = NodeKind.m5778constructorimpl(1024);
        int i3 = 0;
        boolean value$iv$iv$iv$iv = $this$visitLocalDescendants_u2d6rFNWt0$iv3.getNode().getIsAttached();
        if (!value$iv$iv$iv$iv) {
            InlineClassHelperKt.throwIllegalStateException("visitLocalDescendants called on an unattached node");
        }
        Modifier.Node self$iv$iv$iv = $this$visitLocalDescendants_u2d6rFNWt0$iv3.getNode();
        if ((self$iv$iv$iv.getAggregateChildKindSet() & type$iv3) != 0) {
            Modifier.Node next$iv$iv$iv = self$iv$iv$iv.getChild();
            while (next$iv$iv$iv != null) {
                if ((next$iv$iv$iv.getKindSet() & type$iv3) != 0) {
                    Modifier.Node it$iv = next$iv$iv$iv;
                    MutableVector mutableVector2 = null;
                    Modifier.Node nodePop = it$iv;
                    while (nodePop != null) {
                        boolean foundFocusTargetOfFocusGroup2 = foundFocusTargetOfFocusGroup;
                        boolean foundFocusTargetOfFocusGroup3 = nodePop instanceof FocusTargetNode;
                        if (foundFocusTargetOfFocusGroup3) {
                            FocusTargetNode it = (FocusTargetNode) nodePop;
                            if (foundFocusTargetOfFocusGroup2) {
                                return it;
                            }
                            $this$visitLocalDescendants_u2d6rFNWt0$iv = $this$visitLocalDescendants_u2d6rFNWt0$iv3;
                            type$iv = type$iv3;
                            i = i3;
                            foundFocusTargetOfFocusGroup = true;
                        } else {
                            Modifier.Node this_$iv$iv$iv = nodePop;
                            if (((this_$iv$iv$iv.getKindSet() & type$iv3) != 0 ? 1 : 0) == 0 || !(nodePop instanceof DelegatingNode)) {
                                $this$visitLocalDescendants_u2d6rFNWt0$iv = $this$visitLocalDescendants_u2d6rFNWt0$iv3;
                                type$iv = type$iv3;
                                i = i3;
                                foundFocusTargetOfFocusGroup = foundFocusTargetOfFocusGroup2;
                            } else {
                                int count$iv$iv2 = 0;
                                DelegatingNode this_$iv$iv$iv2 = (DelegatingNode) nodePop;
                                Modifier.Node node$iv$iv$iv = this_$iv$iv$iv2.getDelegate();
                                while (node$iv$iv$iv != null) {
                                    Modifier.Node next$iv$iv = node$iv$iv$iv;
                                    if (!((next$iv$iv.getKindSet() & type$iv3) != 0)) {
                                        $this$visitLocalDescendants_u2d6rFNWt0$iv2 = $this$visitLocalDescendants_u2d6rFNWt0$iv3;
                                        type$iv2 = type$iv3;
                                        i2 = i3;
                                    } else {
                                        count$iv$iv2++;
                                        $this$visitLocalDescendants_u2d6rFNWt0$iv2 = $this$visitLocalDescendants_u2d6rFNWt0$iv3;
                                        if (count$iv$iv2 == 1) {
                                            nodePop = next$iv$iv;
                                            type$iv2 = type$iv3;
                                            i2 = i3;
                                        } else {
                                            if (mutableVector2 != null) {
                                                count$iv$iv = count$iv$iv2;
                                                type$iv2 = type$iv3;
                                                i2 = i3;
                                                mutableVector = mutableVector2;
                                            } else {
                                                count$iv$iv = count$iv$iv2;
                                                type$iv2 = type$iv3;
                                                i2 = i3;
                                                mutableVector = new MutableVector(new Modifier.Node[16], 0);
                                            }
                                            Modifier.Node theNode$iv$iv = nodePop;
                                            if (theNode$iv$iv != null) {
                                                if (mutableVector != null) {
                                                    mutableVector.add(theNode$iv$iv);
                                                }
                                                nodePop = null;
                                            }
                                            if (mutableVector != null) {
                                                mutableVector.add(next$iv$iv);
                                            }
                                            mutableVector2 = mutableVector;
                                            count$iv$iv2 = count$iv$iv;
                                        }
                                    }
                                    node$iv$iv$iv = node$iv$iv$iv.getChild();
                                    $this$visitLocalDescendants_u2d6rFNWt0$iv3 = $this$visitLocalDescendants_u2d6rFNWt0$iv2;
                                    type$iv3 = type$iv2;
                                    i3 = i2;
                                }
                                $this$visitLocalDescendants_u2d6rFNWt0$iv = $this$visitLocalDescendants_u2d6rFNWt0$iv3;
                                type$iv = type$iv3;
                                i = i3;
                                if (count$iv$iv2 != 1) {
                                    foundFocusTargetOfFocusGroup = foundFocusTargetOfFocusGroup2;
                                } else {
                                    foundFocusTargetOfFocusGroup = foundFocusTargetOfFocusGroup2;
                                    $this$visitLocalDescendants_u2d6rFNWt0$iv3 = $this$visitLocalDescendants_u2d6rFNWt0$iv;
                                    type$iv3 = type$iv;
                                    i3 = i;
                                }
                            }
                        }
                        nodePop = DelegatableNodeKt.pop(mutableVector2);
                        $this$visitLocalDescendants_u2d6rFNWt0$iv3 = $this$visitLocalDescendants_u2d6rFNWt0$iv;
                        type$iv3 = type$iv;
                        i3 = i;
                    }
                }
                next$iv$iv$iv = next$iv$iv$iv.getChild();
                $this$visitLocalDescendants_u2d6rFNWt0$iv3 = $this$visitLocalDescendants_u2d6rFNWt0$iv3;
                type$iv3 = type$iv3;
                i3 = i3;
            }
        }
        throw new IllegalStateException("Could not find focus target of embedded view wrapper".toString());
    }

    @Override // android.view.ViewTreeObserver.OnGlobalFocusChangeListener
    public void onGlobalFocusChanged(View oldFocus, View newFocus) {
        if (DelegatableNodeKt.requireLayoutNode(this).getOwner() == null) {
            return;
        }
        View embeddedView = FocusGroupNode_androidKt.getView(this);
        FocusOwner focusOwner = DelegatableNodeKt.requireOwner(this).getFocusOwner();
        Owner hostView = DelegatableNodeKt.requireOwner(this);
        boolean subViewLostFocus = (oldFocus == null || Intrinsics.areEqual(oldFocus, hostView) || !FocusGroupNode_androidKt.containsDescendant(embeddedView, oldFocus)) ? false : true;
        boolean subViewGotFocus = (newFocus == null || Intrinsics.areEqual(newFocus, hostView) || !FocusGroupNode_androidKt.containsDescendant(embeddedView, newFocus)) ? false : true;
        if (subViewLostFocus && subViewGotFocus) {
            this.focusedChild = newFocus;
            return;
        }
        if (!subViewGotFocus) {
            if (subViewLostFocus) {
                this.focusedChild = null;
                if (getFocusTargetOfEmbeddedViewWrapper().getFocusState().isFocused()) {
                    focusOwner.mo3873clearFocusI7lrPNg(false, true, false, FocusDirection.INSTANCE.m3865getExitdhqQ8s());
                    return;
                }
                return;
            }
            this.focusedChild = null;
            return;
        }
        this.focusedChild = newFocus;
        FocusTargetNode focusTargetNode = getFocusTargetOfEmbeddedViewWrapper();
        if (!focusTargetNode.getFocusState().getHasFocus()) {
            FocusTransactionManager $this$iv = focusOwner.getFocusTransactionManager();
            try {
                if ($this$iv.ongoingTransaction) {
                    $this$iv.cancelTransaction();
                }
                $this$iv.beginTransaction();
                FocusTransactionsKt.performRequestFocus(focusTargetNode);
            } finally {
                $this$iv.commitTransaction();
            }
        }
    }

    @Override // androidx.compose.ui.Modifier.Node
    public void onAttach() {
        super.onAttach();
        FocusGroupNode_androidKt.getView(this).addOnAttachStateChangeListener(this);
    }

    @Override // androidx.compose.ui.Modifier.Node
    public void onDetach() {
        FocusGroupNode_androidKt.getView(this).removeOnAttachStateChangeListener(this);
        this.focusedChild = null;
        super.onDetach();
    }

    @Override // android.view.View.OnAttachStateChangeListener
    public void onViewAttachedToWindow(View v) {
        v.getViewTreeObserver().addOnGlobalFocusChangeListener(this);
    }

    @Override // android.view.View.OnAttachStateChangeListener
    public void onViewDetachedFromWindow(View v) {
        v.getViewTreeObserver().removeOnGlobalFocusChangeListener(this);
    }
}
