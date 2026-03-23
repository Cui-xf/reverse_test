package androidx.compose.foundation.text;

import androidx.autofill.HintConstants;
import androidx.compose.foundation.relocation.BringIntoViewRequester;
import androidx.compose.foundation.text.selection.TextFieldSelectionManager;
import androidx.compose.foundation.text.selection.TextFieldSelectionManagerKt;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.RecomposeScopeImplKt;
import androidx.compose.runtime.ScopeUpdateScope;
import androidx.compose.runtime.State;
import androidx.compose.runtime.snapshots.Snapshot;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.focus.FocusRequester;
import androidx.compose.ui.geometry.Rect;
import androidx.compose.ui.input.key.KeyEvent;
import androidx.compose.ui.input.key.KeyInputModifierKt;
import androidx.compose.ui.layout.LayoutCoordinates;
import androidx.compose.ui.platform.SoftwareKeyboardController;
import androidx.compose.ui.text.TextLayoutResult;
import androidx.compose.ui.text.TextRange;
import androidx.compose.ui.text.input.ImeOptions;
import androidx.compose.ui.text.input.OffsetMapping;
import androidx.compose.ui.text.input.TextFieldValue;
import androidx.compose.ui.text.input.TextInputService;
import androidx.compose.ui.text.input.TextInputSession;
import androidx.compose.ui.text.style.ResolvedTextDirection;
import androidx.compose.ui.unit.IntSize;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;

/* compiled from: CoreTextField.kt */
@Metadata(d1 = {"\u0000\u009a\u0001\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\u001aî\u0001\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00032\u0012\u0010\u0004\u001a\u000e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u00010\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u00072\b\b\u0002\u0010\b\u001a\u00020\t2\b\b\u0002\u0010\n\u001a\u00020\u000b2\u0014\b\u0002\u0010\f\u001a\u000e\u0012\u0004\u0012\u00020\r\u0012\u0004\u0012\u00020\u00010\u00052\n\b\u0002\u0010\u000e\u001a\u0004\u0018\u00010\u000f2\b\b\u0002\u0010\u0010\u001a\u00020\u00112\b\b\u0002\u0010\u0012\u001a\u00020\u00132\b\b\u0002\u0010\u0014\u001a\u00020\u00152\b\b\u0002\u0010\u0016\u001a\u00020\u00152\b\b\u0002\u0010\u0017\u001a\u00020\u00182\b\b\u0002\u0010\u0019\u001a\u00020\u001a2\b\b\u0002\u0010\u001b\u001a\u00020\u00132\b\b\u0002\u0010\u001c\u001a\u00020\u001323\b\u0002\u0010\u001d\u001a-\u0012\u001e\u0012\u001c\u0012\u0004\u0012\u00020\u00010\u001e¢\u0006\u0002\b\u001f¢\u0006\f\b \u0012\b\b!\u0012\u0004\b\b(\"\u0012\u0004\u0012\u00020\u00010\u0005¢\u0006\u0002\b\u001fH\u0001¢\u0006\u0002\u0010#\u001a0\u0010$\u001a\u00020\u00012\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010%\u001a\u00020&2\u0011\u0010'\u001a\r\u0012\u0004\u0012\u00020\u00010\u001e¢\u0006\u0002\b\u001fH\u0003¢\u0006\u0002\u0010(\u001a\u001d\u0010)\u001a\u00020\u00012\u0006\u0010%\u001a\u00020&2\u0006\u0010*\u001a\u00020\u0013H\u0003¢\u0006\u0002\u0010+\u001a\u0015\u0010,\u001a\u00020\u00012\u0006\u0010%\u001a\u00020&H\u0001¢\u0006\u0002\u0010-\u001a\u0010\u0010.\u001a\u00020\u00012\u0006\u0010/\u001a\u000200H\u0002\u001a \u00101\u001a\u00020\u00012\u0006\u0010/\u001a\u0002002\u0006\u0010\u0002\u001a\u00020\u00032\u0006\u00102\u001a\u000203H\u0002\u001a0\u00104\u001a\u00020\u00012\u0006\u00105\u001a\u0002062\u0006\u0010/\u001a\u0002002\u0006\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0017\u001a\u00020\u00182\u0006\u00102\u001a\u000203H\u0002\u001a \u00107\u001a\u00020\u00012\u0006\u0010/\u001a\u0002002\u0006\u00108\u001a\u0002092\u0006\u0010:\u001a\u00020\u0013H\u0002\u001a2\u0010;\u001a\u00020\u0001*\u00020<2\u0006\u0010\u0002\u001a\u00020\u00032\u0006\u0010=\u001a\u00020>2\u0006\u0010?\u001a\u00020\r2\u0006\u00102\u001a\u000203H\u0080@¢\u0006\u0002\u0010@\u001a\u001c\u0010A\u001a\u00020\u0007*\u00020\u00072\u0006\u0010/\u001a\u0002002\u0006\u0010%\u001a\u00020&H\u0002¨\u0006B²\u0006\n\u0010C\u001a\u00020\u0013X\u008a\u0084\u0002"}, d2 = {"CoreTextField", "", "value", "Landroidx/compose/ui/text/input/TextFieldValue;", "onValueChange", "Lkotlin/Function1;", "modifier", "Landroidx/compose/ui/Modifier;", "textStyle", "Landroidx/compose/ui/text/TextStyle;", "visualTransformation", "Landroidx/compose/ui/text/input/VisualTransformation;", "onTextLayout", "Landroidx/compose/ui/text/TextLayoutResult;", "interactionSource", "Landroidx/compose/foundation/interaction/MutableInteractionSource;", "cursorBrush", "Landroidx/compose/ui/graphics/Brush;", "softWrap", "", "maxLines", "", "minLines", "imeOptions", "Landroidx/compose/ui/text/input/ImeOptions;", "keyboardActions", "Landroidx/compose/foundation/text/KeyboardActions;", "enabled", "readOnly", "decorationBox", "Lkotlin/Function0;", "Landroidx/compose/runtime/Composable;", "Lkotlin/ParameterName;", HintConstants.AUTOFILL_HINT_NAME, "innerTextField", "(Landroidx/compose/ui/text/input/TextFieldValue;Lkotlin/jvm/functions/Function1;Landroidx/compose/ui/Modifier;Landroidx/compose/ui/text/TextStyle;Landroidx/compose/ui/text/input/VisualTransformation;Lkotlin/jvm/functions/Function1;Landroidx/compose/foundation/interaction/MutableInteractionSource;Landroidx/compose/ui/graphics/Brush;ZIILandroidx/compose/ui/text/input/ImeOptions;Landroidx/compose/foundation/text/KeyboardActions;ZZLkotlin/jvm/functions/Function3;Landroidx/compose/runtime/Composer;III)V", "CoreTextFieldRootBox", "manager", "Landroidx/compose/foundation/text/selection/TextFieldSelectionManager;", "content", "(Landroidx/compose/ui/Modifier;Landroidx/compose/foundation/text/selection/TextFieldSelectionManager;Lkotlin/jvm/functions/Function2;Landroidx/compose/runtime/Composer;I)V", "SelectionToolbarAndHandles", "show", "(Landroidx/compose/foundation/text/selection/TextFieldSelectionManager;ZLandroidx/compose/runtime/Composer;I)V", "TextFieldCursorHandle", "(Landroidx/compose/foundation/text/selection/TextFieldSelectionManager;Landroidx/compose/runtime/Composer;I)V", "endInputSession", "state", "Landroidx/compose/foundation/text/LegacyTextFieldState;", "notifyFocusedRect", "offsetMapping", "Landroidx/compose/ui/text/input/OffsetMapping;", "startInputSession", "textInputService", "Landroidx/compose/ui/text/input/TextInputService;", "tapToFocus", "focusRequester", "Landroidx/compose/ui/focus/FocusRequester;", "allowKeyboard", "bringSelectionEndIntoView", "Landroidx/compose/foundation/relocation/BringIntoViewRequester;", "textDelegate", "Landroidx/compose/foundation/text/TextDelegate;", "textLayoutResult", "(Landroidx/compose/foundation/relocation/BringIntoViewRequester;Landroidx/compose/ui/text/input/TextFieldValue;Landroidx/compose/foundation/text/TextDelegate;Landroidx/compose/ui/text/TextLayoutResult;Landroidx/compose/ui/text/input/OffsetMapping;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "previewKeyEventToDeselectOnBack", "foundation_release", "writeable"}, k = 2, mv = {1, 8, 0}, xi = 48)
/* loaded from: classes.dex */
public final class CoreTextFieldKt {
    /* JADX WARN: Removed duplicated region for block: B:270:0x0538  */
    /* JADX WARN: Removed duplicated region for block: B:271:0x053a  */
    /* JADX WARN: Removed duplicated region for block: B:274:0x0546  */
    /* JADX WARN: Removed duplicated region for block: B:275:0x0548  */
    /* JADX WARN: Removed duplicated region for block: B:278:0x0558  */
    /* JADX WARN: Removed duplicated region for block: B:282:0x056c  */
    /* JADX WARN: Removed duplicated region for block: B:285:0x057f  */
    /* JADX WARN: Removed duplicated region for block: B:288:0x0594  */
    /* JADX WARN: Removed duplicated region for block: B:293:0x05cd  */
    /* JADX WARN: Removed duplicated region for block: B:297:0x05e7 A[ADDED_TO_REGION] */
    /* JADX WARN: Removed duplicated region for block: B:301:0x0694  */
    /* JADX WARN: Removed duplicated region for block: B:302:0x06ab  */
    /* JADX WARN: Removed duplicated region for block: B:305:0x06e6  */
    /* JADX WARN: Removed duplicated region for block: B:306:0x06f4  */
    /* JADX WARN: Removed duplicated region for block: B:309:0x0799  */
    /* JADX WARN: Removed duplicated region for block: B:310:0x07b6  */
    /* JADX WARN: Removed duplicated region for block: B:313:0x07e4  */
    /* JADX WARN: Removed duplicated region for block: B:314:0x07ef  */
    /* JADX WARN: Removed duplicated region for block: B:317:0x0811  */
    /* JADX WARN: Removed duplicated region for block: B:318:0x0813  */
    /* JADX WARN: Removed duplicated region for block: B:321:0x081e  */
    /* JADX WARN: Removed duplicated region for block: B:322:0x0820  */
    /* JADX WARN: Removed duplicated region for block: B:325:0x082f  */
    /* JADX WARN: Removed duplicated region for block: B:326:0x0831  */
    /* JADX WARN: Removed duplicated region for block: B:329:0x083e  */
    /* JADX WARN: Removed duplicated region for block: B:331:0x0844  */
    /* JADX WARN: Removed duplicated region for block: B:337:0x0870  */
    /* JADX WARN: Removed duplicated region for block: B:341:0x088c  */
    /* JADX WARN: Removed duplicated region for block: B:345:0x08d2 A[ADDED_TO_REGION] */
    /* JADX WARN: Removed duplicated region for block: B:347:0x08d6  */
    /* JADX WARN: Removed duplicated region for block: B:358:0x092a  */
    /* JADX WARN: Removed duplicated region for block: B:362:0x0939  */
    /* JADX WARN: Removed duplicated region for block: B:366:0x0981  */
    /* JADX WARN: Removed duplicated region for block: B:370:0x098f A[ADDED_TO_REGION] */
    /* JADX WARN: Removed duplicated region for block: B:374:0x09bb  */
    /* JADX WARN: Removed duplicated region for block: B:375:0x09bd  */
    /* JADX WARN: Removed duplicated region for block: B:378:0x09c5  */
    /* JADX WARN: Removed duplicated region for block: B:379:0x09c7  */
    /* JADX WARN: Removed duplicated region for block: B:382:0x09df  */
    /* JADX WARN: Removed duplicated region for block: B:386:0x09fa  */
    /* JADX WARN: Removed duplicated region for block: B:390:0x0a66  */
    /* JADX WARN: Removed duplicated region for block: B:391:0x0a68  */
    /* JADX WARN: Removed duplicated region for block: B:394:0x0a7b  */
    /* JADX WARN: Removed duplicated region for block: B:398:0x0a89 A[ADDED_TO_REGION] */
    /* JADX WARN: Removed duplicated region for block: B:402:0x0abb  */
    /* JADX WARN: Removed duplicated region for block: B:403:0x0abd  */
    /* JADX WARN: Removed duplicated region for block: B:406:0x0ad7  */
    /* JADX WARN: Removed duplicated region for block: B:407:0x0ad9  */
    /* JADX WARN: Removed duplicated region for block: B:410:0x0aee  */
    /* JADX WARN: Removed duplicated region for block: B:414:0x0b00  */
    /* JADX WARN: Removed duplicated region for block: B:417:0x0b49  */
    /* JADX WARN: Removed duplicated region for block: B:418:0x0b4b  */
    /* JADX WARN: Removed duplicated region for block: B:421:0x0b56  */
    /* JADX WARN: Removed duplicated region for block: B:422:0x0b58  */
    /* JADX WARN: Removed duplicated region for block: B:425:0x0b65  */
    /* JADX WARN: Removed duplicated region for block: B:426:0x0b67  */
    /* JADX WARN: Removed duplicated region for block: B:437:0x0b9c  */
    /* JADX WARN: Removed duplicated region for block: B:441:0x0bba A[ADDED_TO_REGION] */
    /* JADX WARN: Removed duplicated region for block: B:445:0x0c01 A[ADDED_TO_REGION] */
    /* JADX WARN: Removed duplicated region for block: B:451:0x0c11  */
    /* JADX WARN: Removed duplicated region for block: B:454:0x0c46  */
    /* JADX WARN: Removed duplicated region for block: B:458:0x0c56  */
    /* JADX WARN: Removed duplicated region for block: B:462:0x0c8b  */
    /* JADX WARN: Removed duplicated region for block: B:463:0x0c8d  */
    /* JADX WARN: Removed duplicated region for block: B:466:0x0c98  */
    /* JADX WARN: Removed duplicated region for block: B:468:0x0c9e  */
    /* JADX WARN: Removed duplicated region for block: B:474:0x0cb4  */
    /* JADX WARN: Removed duplicated region for block: B:478:0x0cc2 A[ADDED_TO_REGION] */
    /* JADX WARN: Removed duplicated region for block: B:482:0x0cf6  */
    /* JADX WARN: Removed duplicated region for block: B:483:0x0cf9  */
    /* JADX WARN: Removed duplicated region for block: B:486:0x0d3b  */
    /* JADX WARN: Removed duplicated region for block: B:488:0x0d41  */
    /* JADX WARN: Removed duplicated region for block: B:494:0x0d62  */
    /* JADX WARN: Removed duplicated region for block: B:498:0x0d72 A[ADDED_TO_REGION] */
    /* JADX WARN: Removed duplicated region for block: B:502:0x0dcc  */
    /* JADX WARN: Removed duplicated region for block: B:509:0x0de1  */
    /* JADX WARN: Removed duplicated region for block: B:512:0x0de6  */
    /* JADX WARN: Removed duplicated region for block: B:513:0x0def  */
    /* JADX WARN: Removed duplicated region for block: B:516:0x0e6b  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static final void CoreTextField(final androidx.compose.ui.text.input.TextFieldValue r57, final kotlin.jvm.functions.Function1<? super androidx.compose.ui.text.input.TextFieldValue, kotlin.Unit> r58, androidx.compose.ui.Modifier r59, androidx.compose.ui.text.TextStyle r60, androidx.compose.ui.text.input.VisualTransformation r61, kotlin.jvm.functions.Function1<? super androidx.compose.ui.text.TextLayoutResult, kotlin.Unit> r62, androidx.compose.foundation.interaction.MutableInteractionSource r63, androidx.compose.ui.graphics.Brush r64, boolean r65, int r66, int r67, androidx.compose.ui.text.input.ImeOptions r68, androidx.compose.foundation.text.KeyboardActions r69, boolean r70, boolean r71, kotlin.jvm.functions.Function3<? super kotlin.jvm.functions.Function2<? super androidx.compose.runtime.Composer, ? super java.lang.Integer, kotlin.Unit>, ? super androidx.compose.runtime.Composer, ? super java.lang.Integer, kotlin.Unit> r72, androidx.compose.runtime.Composer r73, final int r74, final int r75, final int r76) {
        /*
            Method dump skipped, instructions count: 3756
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.compose.foundation.text.CoreTextFieldKt.CoreTextField(androidx.compose.ui.text.input.TextFieldValue, kotlin.jvm.functions.Function1, androidx.compose.ui.Modifier, androidx.compose.ui.text.TextStyle, androidx.compose.ui.text.input.VisualTransformation, kotlin.jvm.functions.Function1, androidx.compose.foundation.interaction.MutableInteractionSource, androidx.compose.ui.graphics.Brush, boolean, int, int, androidx.compose.ui.text.input.ImeOptions, androidx.compose.foundation.text.KeyboardActions, boolean, boolean, kotlin.jvm.functions.Function3, androidx.compose.runtime.Composer, int, int, int):void");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final boolean CoreTextField$lambda$11(State<Boolean> state) {
        Object thisObj$iv = state.getValue();
        return ((Boolean) thisObj$iv).booleanValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Removed duplicated region for block: B:49:0x0194  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static final void CoreTextFieldRootBox(final androidx.compose.ui.Modifier r28, final androidx.compose.foundation.text.selection.TextFieldSelectionManager r29, final kotlin.jvm.functions.Function2<? super androidx.compose.runtime.Composer, ? super java.lang.Integer, kotlin.Unit> r30, androidx.compose.runtime.Composer r31, final int r32) {
        /*
            Method dump skipped, instructions count: 424
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.compose.foundation.text.CoreTextFieldKt.CoreTextFieldRootBox(androidx.compose.ui.Modifier, androidx.compose.foundation.text.selection.TextFieldSelectionManager, kotlin.jvm.functions.Function2, androidx.compose.runtime.Composer, int):void");
    }

    private static final Modifier previewKeyEventToDeselectOnBack(Modifier $this$previewKeyEventToDeselectOnBack, final LegacyTextFieldState state, final TextFieldSelectionManager manager) {
        return KeyInputModifierKt.onPreviewKeyEvent($this$previewKeyEventToDeselectOnBack, new Function1<KeyEvent, Boolean>() { // from class: androidx.compose.foundation.text.CoreTextFieldKt.previewKeyEventToDeselectOnBack.1
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Boolean invoke(KeyEvent keyEvent) {
                return m1000invokeZmokQxo(keyEvent.m5246unboximpl());
            }

            /* renamed from: invoke-ZmokQxo, reason: not valid java name */
            public final Boolean m1000invokeZmokQxo(android.view.KeyEvent keyEvent) {
                boolean z;
                if (state.getHandleState() == HandleState.Selection && KeyEventHelpers_androidKt.m1002cancelsTextSelectionZmokQxo(keyEvent)) {
                    z = true;
                    TextFieldSelectionManager.m1396deselect_kEHs6E$foundation_release$default(manager, null, 1, null);
                } else {
                    z = false;
                }
                return Boolean.valueOf(z);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void tapToFocus(LegacyTextFieldState state, FocusRequester focusRequester, boolean allowKeyboard) {
        SoftwareKeyboardController keyboardController;
        if (!state.getHasFocus()) {
            focusRequester.requestFocus();
        } else {
            if (!allowKeyboard || (keyboardController = state.getKeyboardController()) == null) {
                return;
            }
            keyboardController.show();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void startInputSession(TextInputService textInputService, LegacyTextFieldState state, TextFieldValue value, ImeOptions imeOptions, OffsetMapping offsetMapping) {
        state.setInputSession(TextFieldDelegate.INSTANCE.onFocus$foundation_release(textInputService, value, state.getProcessor(), imeOptions, state.getOnValueChange(), state.getOnImeActionPerformed()));
        notifyFocusedRect(state, value, offsetMapping);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void endInputSession(LegacyTextFieldState state) {
        TextInputSession session = state.getInputSession();
        if (session != null) {
            TextFieldDelegate.INSTANCE.onBlur$foundation_release(session, state.getProcessor(), state.getOnValueChange());
        }
        state.setInputSession(null);
    }

    public static final Object bringSelectionEndIntoView(BringIntoViewRequester $this$bringSelectionEndIntoView, TextFieldValue value, TextDelegate textDelegate, TextLayoutResult textLayoutResult, OffsetMapping offsetMapping, Continuation<? super Unit> continuation) {
        Rect selectionEndBounds;
        int selectionEndInTransformed = offsetMapping.originalToTransformed(TextRange.m6143getMaximpl(value.getSelection()));
        if (selectionEndInTransformed < textLayoutResult.getLayoutInput().getText().length()) {
            selectionEndBounds = textLayoutResult.getBoundingBox(selectionEndInTransformed);
        } else if (selectionEndInTransformed != 0) {
            selectionEndBounds = textLayoutResult.getBoundingBox(selectionEndInTransformed - 1);
        } else {
            long defaultSize = TextFieldDelegateKt.computeSizeForDefaultText$default(textDelegate.getStyle(), textDelegate.getDensity(), textDelegate.getFontFamilyResolver(), null, 0, 24, null);
            selectionEndBounds = new Rect(0.0f, 0.0f, 1.0f, IntSize.m6866getHeightimpl(defaultSize));
        }
        Object objBringIntoView = $this$bringSelectionEndIntoView.bringIntoView(selectionEndBounds, continuation);
        return objBringIntoView == IntrinsicsKt.getCOROUTINE_SUSPENDED() ? objBringIntoView : Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void SelectionToolbarAndHandles(final TextFieldSelectionManager manager, final boolean show, Composer $composer, final int $changed) {
        TextLayoutResultProxy layoutResult;
        TextLayoutResult value;
        Composer $composer2 = $composer.startRestartGroup(626339208);
        ComposerKt.sourceInformation($composer2, "C(SelectionToolbarAndHandles):CoreTextField.kt#423gt5");
        int $dirty = $changed;
        if (($changed & 6) == 0) {
            $dirty |= $composer2.changedInstance(manager) ? 4 : 2;
        }
        if (($changed & 48) == 0) {
            $dirty |= $composer2.changed(show) ? 32 : 16;
        }
        if (($dirty & 19) != 18 || !$composer2.getSkipping()) {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(626339208, $dirty, -1, "androidx.compose.foundation.text.SelectionToolbarAndHandles (CoreTextField.kt:1146)");
            }
            if (show) {
                $composer2.startReplaceGroup(-1286242594);
                ComposerKt.sourceInformation($composer2, "");
                LegacyTextFieldState state = manager.getState();
                TextLayoutResult it = null;
                if (state != null && (layoutResult = state.getLayoutResult()) != null && (value = layoutResult.getValue()) != null) {
                    LegacyTextFieldState state2 = manager.getState();
                    if (!(state2 != null ? state2.getIsLayoutResultStale() : true)) {
                        it = value;
                    }
                }
                if (it == null) {
                    $composer2.startReplaceGroup(-1285984396);
                } else {
                    $composer2.startReplaceGroup(-1285984395);
                    ComposerKt.sourceInformation($composer2, "");
                    if (!TextRange.m6140getCollapsedimpl(manager.getValue$foundation_release().getSelection())) {
                        $composer2.startReplaceGroup(-1680616096);
                        ComposerKt.sourceInformation($composer2, "");
                        int startOffset = manager.getOffsetMapping().originalToTransformed(TextRange.m6146getStartimpl(manager.getValue$foundation_release().getSelection()));
                        int endOffset = manager.getOffsetMapping().originalToTransformed(TextRange.m6141getEndimpl(manager.getValue$foundation_release().getSelection()));
                        ResolvedTextDirection startDirection = it.getBidiRunDirection(startOffset);
                        ResolvedTextDirection endDirection = it.getBidiRunDirection(Math.max(endOffset - 1, 0));
                        LegacyTextFieldState state3 = manager.getState();
                        if (state3 != null && state3.getShowSelectionHandleStart()) {
                            $composer2.startReplaceGroup(-1680216289);
                            ComposerKt.sourceInformation($composer2, "1158@51449L203");
                            TextFieldSelectionManagerKt.TextFieldSelectionHandle(true, startDirection, manager, $composer2, (($dirty << 6) & 896) | 6);
                            $composer2.endReplaceGroup();
                        } else {
                            $composer2.startReplaceGroup(-1679975078);
                            $composer2.endReplaceGroup();
                        }
                        LegacyTextFieldState state4 = manager.getState();
                        if (state4 != null && state4.getShowSelectionHandleEnd()) {
                            $composer2.startReplaceGroup(-1679895904);
                            ComposerKt.sourceInformation($composer2, "1165@51772L202");
                            TextFieldSelectionManagerKt.TextFieldSelectionHandle(false, endDirection, manager, $composer2, (($dirty << 6) & 896) | 6);
                            $composer2.endReplaceGroup();
                        } else {
                            $composer2.startReplaceGroup(-1679655654);
                            $composer2.endReplaceGroup();
                        }
                        $composer2.endReplaceGroup();
                    } else {
                        $composer2.startReplaceGroup(-1679637798);
                        $composer2.endReplaceGroup();
                    }
                    LegacyTextFieldState textFieldState = manager.getState();
                    if (textFieldState != null) {
                        if (manager.isTextChanged$foundation_release()) {
                            textFieldState.setShowFloatingToolbar(false);
                        }
                        if (textFieldState.getHasFocus()) {
                            if (textFieldState.getShowFloatingToolbar()) {
                                manager.showSelectionToolbar$foundation_release();
                            } else {
                                manager.hideSelectionToolbar$foundation_release();
                            }
                        }
                        Unit unit = Unit.INSTANCE;
                    }
                }
                $composer2.endReplaceGroup();
                $composer2.endReplaceGroup();
            } else {
                $composer2.startReplaceGroup(651305535);
                $composer2.endReplaceGroup();
                manager.hideSelectionToolbar$foundation_release();
            }
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        } else {
            $composer2.skipToGroupEnd();
        }
        ScopeUpdateScope scopeUpdateScopeEndRestartGroup = $composer2.endRestartGroup();
        if (scopeUpdateScopeEndRestartGroup != null) {
            scopeUpdateScopeEndRestartGroup.updateScope(new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.foundation.text.CoreTextFieldKt.SelectionToolbarAndHandles.2
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                {
                    super(2);
                }

                @Override // kotlin.jvm.functions.Function2
                public /* bridge */ /* synthetic */ Unit invoke(Composer composer, Integer num) {
                    invoke(composer, num.intValue());
                    return Unit.INSTANCE;
                }

                public final void invoke(Composer composer, int i) {
                    CoreTextFieldKt.SelectionToolbarAndHandles(manager, show, composer, RecomposeScopeImplKt.updateChangedFlags($changed | 1));
                }
            });
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:33:0x0067  */
    /* JADX WARN: Removed duplicated region for block: B:35:0x006a  */
    /* JADX WARN: Removed duplicated region for block: B:64:0x0182  */
    /* JADX WARN: Removed duplicated region for block: B:67:0x0191  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static final void TextFieldCursorHandle(final androidx.compose.foundation.text.selection.TextFieldSelectionManager r18, androidx.compose.runtime.Composer r19, final int r20) {
        /*
            Method dump skipped, instructions count: 421
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.compose.foundation.text.CoreTextFieldKt.TextFieldCursorHandle(androidx.compose.foundation.text.selection.TextFieldSelectionManager, androidx.compose.runtime.Composer, int):void");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void notifyFocusedRect(LegacyTextFieldState state, TextFieldValue value, OffsetMapping offsetMapping) {
        TextInputSession inputSession;
        LayoutCoordinates layoutCoordinates;
        Snapshot.Companion this_$iv = Snapshot.INSTANCE;
        Snapshot previousSnapshot$iv = this_$iv.getCurrentThreadSnapshot();
        Function1 observer$iv = previousSnapshot$iv != null ? previousSnapshot$iv.getReadObserver() : null;
        Snapshot newSnapshot$iv = this_$iv.makeCurrentNonObservable(previousSnapshot$iv);
        try {
            TextLayoutResultProxy layoutResult = state.getLayoutResult();
            if (layoutResult != null && (inputSession = state.getInputSession()) != null && (layoutCoordinates = state.getLayoutCoordinates()) != null) {
                TextFieldDelegate.INSTANCE.notifyFocusedRect$foundation_release(value, state.getTextDelegate(), layoutResult.getValue(), layoutCoordinates, inputSession, state.getHasFocus(), offsetMapping);
                Unit unit = Unit.INSTANCE;
            }
        } finally {
            this_$iv.restoreNonObservable(previousSnapshot$iv, newSnapshot$iv, observer$iv);
        }
    }
}
